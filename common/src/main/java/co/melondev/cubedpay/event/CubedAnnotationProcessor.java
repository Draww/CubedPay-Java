package co.melondev.cubedpay.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class CubedAnnotationProcessor {

    private Map<Method, Class<?>> eventHandlers = new HashMap<>();
    private Map<Method, Object> eventClasses = new HashMap<>();

    public void processAnnotation(Object instance) {
        if (!Modifier.isPublic(instance.getClass().getModifiers())) {
            System.out.println("CubedPay - Error: Registered listener class is not public! (" + instance.getClass().getName() + ")");
            return;
        }
        Arrays.stream(instance.getClass().getDeclaredMethods()).filter(m -> m.isAnnotationPresent(PaymentHandler.class)).forEach(method -> {
            Class<?> parameter = method.getParameterTypes()[0];
            if (!CubedEvent.class.isAssignableFrom(parameter)) return;
            eventHandlers.put(method, parameter);
            eventClasses.put(method, instance);
        });
    }

    public boolean emitEvent(CubedEvent event) {
        AtomicBoolean emitted = new AtomicBoolean(false);
        eventHandlers.forEach((method, aClass) -> {
            final Object clazz = eventClasses.get(method);
            try {
                method.invoke(clazz, event);
                emitted.set(true);
            } catch (IllegalAccessException e) {
                System.out.println("CubedPay - Error: Please make sure the listener class is public! (" + clazz.getClass().getName() + ")");
            } catch (InvocationTargetException e) {
                System.out.println("CubedPay - Error: Invoke exception on " + clazz.getClass().getSimpleName() + ":" + method.getName() + "()");
                emitted.set(true);
            } catch (IllegalArgumentException ignored) {
            }
        });
        return emitted.get();
    }
}
