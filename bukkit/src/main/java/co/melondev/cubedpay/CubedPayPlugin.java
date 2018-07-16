package co.melondev.cubedpay;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CubedPayPlugin extends JavaPlugin {

    private static CubedPayAPI api;
    private List<String> shops = new ArrayList<>();

    @Override
    public void onEnable() {
        File dir = getDataFolder();
        if (!dir.exists()) dir.mkdir();

        File config = new File(dir, "config.yml");
        if (!config.exists()) saveDefaultConfig();

        String appId = getConfig().getString("appId", "");
        String token = getConfig().getString("accessToken", "");

        boolean disable = false;
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
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        api = new CubedPayAPI(appId, token);

        List<String> shops = getConfig().getStringList("shops");
        this.shops = shops;

        if (shops.isEmpty()) {
            getLogger().warning("No shops defined in the config! Events will not poll without api assistance!");
            return;
        }

        shops.stream()
                .filter(shop -> !shop.trim().isEmpty())
                .peek(shop -> getLogger().info("Starting event for shop " + shop))
                .forEach(api::startEvents);

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

    public static CubedPayAPI getAPI() {
        return api;
    }

    public static List<String> getShops() {
        return getPlugin(CubedPayPlugin.class).shops;
    }
}
