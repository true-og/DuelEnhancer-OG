// This is free and unencumbered software released into the public domain.
// Author: NotAlexNoyle (admin@true-og.net)

package plugin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import me.realized.duels.api.Duels;
import net.trueog.utilitiesog.UtilitiesOG;

public class Listeners implements Listener {

    // Declare instance of class as static so multiple players can use it.
    private static Listeners instance;

    // Initialize Duels API.
    private static Duels api = (Duels) Bukkit.getServer().getPluginManager().getPlugin("Duels-OG");

    // Return instance of class as static so multiple players can use it.
    public static Listeners getInstance() {

        return instance;

    }

    // Listen for a player's game mode changing.
    @EventHandler
    public void onSurvivalMode(PlayerGameModeChangeEvent event) {

        // Store player as object for multiple references.
        Player player = event.getPlayer();

        // Use Duels API to tell if the player whose game mode has changed is spectating
        // a duel.
        if (api.getSpectateManager().isSpectating(player)) {

            // If the player was put in survival (presumably by WorldGuard), do this...
            if (player.getGameMode() == GameMode.SURVIVAL) {

                // Inform the player that they will stop spectating the match.
                UtilitiesOG.trueogMessage(player,
                        "<gray>[<dark_green>True<red>OG<gray>] <gold>Out of bounds! Your Duel spectating session has ended.");

                // Stop the player from spectating the match.
                api.getSpectateManager().stopSpectating(player);

            }

        }

    }

}