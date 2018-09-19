package co.melondev.cubedpay;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.scheduler.Task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Plugin(id = "cubedpayplugin", name = "CubedPayPlugin", version = "0.4.5", authors = {"Melon Development", "Bert Towne"}, url = "https://cubedpay.com/")
public class CubedPayPlugin {

    private static CubedPayAPI api;
    private static List<String> shops = new ArrayList<>();

    @Inject
    private Logger logger;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private File configFile;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private ConfigurationLoader<CommentedConfigurationNode> configManager;

    private CommentedConfigurationNode config;

    @Listener
    public void onEnable(GameStartingServerEvent event) {
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();

                try {
                    config = configManager.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                config.getNode("appId").setValue("");
                config.getNode("accessToken").setValue("");
                config.getNode("shops").setValue(new TypeToken<ArrayList<String>>() {}, new ArrayList<>());

                try {
                    configManager.save(config);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                config = configManager.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        String appId = config.getNode("appId").getString("");
        String token = config.getNode("accessToken").getString("");

        boolean disable = false;
        if (appId.isEmpty()) {
            logger.error("appId is blank in the config!");
            disable = true;
        }

        if (token.isEmpty()) {
            logger.error("accessToken is blank in the config!");
            disable = true;
        }

        if (disable) {
            logger.error("CubedPayPlugin will now disable.");
            this.disable();

            return;
        }

        api = new CubedPayAPI(appId, token);

        List<String> shopList = null;
        try {
            shopList = config.getNode("shops").getList(TypeToken.of(String.class));
        } catch (ObjectMappingException e) {
            e.printStackTrace();
        }
        shops = shopList;

        if (shops != null) {
            if (shops.isEmpty()) {
                logger.warn("No shops defined in the config! Events will not poll without api assistance!");
                return;
            }

            shops.stream()
                    .filter(shop -> !shop.trim().isEmpty())
                    .peek(shop -> logger.info("Starting events for shop " + shop))
                    .forEach(api::startEvents);
        }
    }

    @Listener
    public void onDisable(GameStoppingServerEvent event) {
        if (api == null) return;

        try {
            api.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void disable() {
        Sponge.getEventManager().unregisterPluginListeners(this);
        Sponge.getCommandManager().getOwnedBy(this).forEach(Sponge.getCommandManager()::removeMapping);
        Sponge.getScheduler().getScheduledTasks(this).forEach(Task::cancel);
    }

    public static CubedPayAPI getAPI() {
        return api;
    }

    public static List<String> getShops() {
        return shops;
    }
}
