package co.melondev.cubedpay;

import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CubedPayPlugin extends Plugin {

    private static CubedPayAPI api;
    private static List<String> shops = new ArrayList<>();

    @Override
    public void onEnable() {
        File dir = getDataFolder();
        if (!dir.exists()) dir.mkdir();

        File configFile = new File(dir, "config.yml");
        if (!configFile.exists()) saveDefaultConfig();

        boolean disable = false;

        try {
            Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));

            String appId = config.getString("appId", "");
            String token = config.getString("accessToken", "");

            if (appId.isEmpty()) {
                getLogger().severe("appId is blank in the config!");
                disable = true;
            }

            if (token.isEmpty()) {
                getLogger().severe("accessToken is blank in the config!");
                disable = true;
            }

            if (disable) {
                getLogger().severe("CubedPayPlugin will now disable.");
                disable();
                return;
            }

            api = new CubedPayAPI(appId, token);
            shops = config.getStringList("shops");

            if (shops.isEmpty()) {
                getLogger().warning("No shops defined in the config! Events will not poll without api assistance!");
                return;
            }

            shops.stream()
                    .filter(shop -> !shop.trim().isEmpty())
                    .peek(shop -> getLogger().info("Starting events for shop " + shop))
                    .forEach(api::startEvents);
        } catch (IOException ex) {
            getLogger().severe("Error loading config.yml!");
            ex.printStackTrace();
            disable();
        }
    }

    @Override
    public void onDisable() {
        if (api == null) return;

        try {
            api.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void saveDefaultConfig() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();

                try (InputStream is = getResourceAsStream("config.yml"); OutputStream os = new FileOutputStream(configFile)) {
                    ByteStreams.copy(is, os);
                }
            } catch (IOException ex) {
                throw new RuntimeException("Unable to create config file", ex);
            }
        }
    }

    private void disable() {
        getProxy().getPluginManager().unregisterCommands(this);
        getProxy().getPluginManager().unregisterListeners(this);
        getProxy().getScheduler().cancel(this);
    }

    public static CubedPayAPI getAPI() {
        return api;
    }

    public static List<String> getShops() {
        return shops;
    }

}