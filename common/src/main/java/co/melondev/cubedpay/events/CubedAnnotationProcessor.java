package co.melondev.cubedpay.events;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class CubedAnnotationProcessor {

    private Multimap<Class<? extends CubedEvent>, Method> eventHandlers = ArrayListMultimap.create();
    private Multimap<Object, Method> listenerObjectMethods = ArrayListMultimap.create();
    private Map<Method, Object> methodOwnerMap = new HashMap<>();

    public void registerListener(Object listener) {
        if (!Modifier.isPublic(listener.getClass().getModifiers())) {
            System.out.println("CubedPay - Error: Registered listener class is not public! (" + listener.getClass().getName() + ")");
            return;
        }
        Arrays.stream(listener.getClass().getDeclaredMethods()).filter(m -> m.isAnnotationPresent(CubedEventHandler.class)).forEach(method -> {
            Class<?> parameter = method.getParameterTypes()[0];
            if (!CubedEvent.class.isAssignableFrom(parameter)) return;
            eventHandlers.put((Class<? extends CubedEvent>) parameter, method);
            listenerObjectMethods.put(listener, method);
            methodOwnerMap.put(method, listener);
        });
    }

    public boolean emitEvent(CubedEvent event) {
        AtomicBoolean emitted = new AtomicBoolean(false);
        eventHandlers.get(event.getClass()).forEach((method) -> {
            Object owner = methodOwnerMap.get(method);
            try {
                method.invoke(Modifier.isStatic(method.getModifiers()) ? null : owner, event);
                emitted.set(event.isProcessed());
            } catch (IllegalAccessException e) {
                System.out.println("CubedPay - Error: Please make sure the listener class is public! (" + owner.getClass().getName() + ")");
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                System.out.println("CubedPay - Error: Invoke exception on " + owner.getClass().getSimpleName() + "#" + method.getName() + "()");
                e.getCause().printStackTrace();
            } catch (IllegalArgumentException ignored) {
            }
        });
        return emitted.get();
    }

    public void removeListener(Object listener) {
        listenerObjectMethods.removeAll(listener).forEach(handlerMethod -> {
            methodOwnerMap.remove(handlerMethod);
            eventHandlers.keySet().forEach(key -> eventHandlers.remove(key, handlerMethod));
        });
    }
}
