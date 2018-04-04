package co.melondev.cubedpay;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class CubedPayPlugin extends JavaPlugin {

    private CubedPayAPI api;
    private CubedPaySettings settings = new CubedPaySettings();

    @Override
    public void onEnable() {
        File dir = getDataFolder();
        if (!dir.exists()) dir.mkdir();

        File config = new File(dir, "config.yml");
        if (!config.exists()) saveDefaultConfig();

        settings.load(getConfig());

        boolean disable = false;
        if (settings.getAppID() == null || settings.getAppID().isEmpty()) {
            getLogger().severe("AppID is blank in the config!");
            disable = true;
        }
        if (settings.getAccessToken() == null || settings.getAccessToken().isEmpty()) {
            getLogger().severe("AccessToken is blank in the config!");
            disable = true;
        }
        if (disable) {
            getLogger().severe("CubedPayPlugin will now disable.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        api = CubedPayAPI.create(settings.getAppID(), settings.getAccessToken());

        if (settings.getShopID() == null || settings.getShopID().isEmpty()) {
            getLogger().severe("ShopID is blank in the config! Not starting event runnable!");
            return;
        }
        api.startEvents(settings.getShopID());
    }

    public static CubedPayAPI getAPI() {
        return getInstance().api;
    }

    public static CubedPaySettings getSettings() {
        return getInstance().settings;
    }

    private static CubedPayPlugin getInstance() {
        return CubedPayPlugin.getPlugin(CubedPayPlugin.class);
    }
}
