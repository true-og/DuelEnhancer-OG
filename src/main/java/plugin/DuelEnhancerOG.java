package plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

// Extending this class is standard bukkit boilerplate for any plugin, or else the server software won't load the
// classes.
public class DuelEnhancerOG extends JavaPlugin {

    // What to do when the plugin is run by the server.
    @Override
    public void onEnable() {

        // Register the Event Listener class.
        this.getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

    // Runs plugin asynchronously so multiple players can use it at once efficiently.
    public BukkitTask runTaskAsynchronously(final Runnable run) {

        // Schedule Processes.
        return this.getServer().getScheduler().runTaskAsynchronously(this, run);
    }
}
