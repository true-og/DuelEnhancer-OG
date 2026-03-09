// This is free and unencumbered software released into the public domain.
// Author: NotAlexNoyle (admin@true-og.net)

package plugin;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import me.realized.duels.api.Duels;
import net.trueog.utilitiesog.UtilitiesOG;

public class Listeners implements Listener {

    // Container to store the received Duels API instance.
    Duels duelsAPI;

    // Class constructor.
    public Listeners(Duels duelsAPI) {

        // Assign the received Duels API instance to the container.
        this.duelsAPI = duelsAPI;

    }

    // Listen for a player's game mode changing.
    @EventHandler
    public void onSurvivalMode(PlayerGameModeChangeEvent event) {

        final Player player = event.getPlayer();
        final boolean condition = duelsAPI.getSpectateManager().isSpectating(player)
                && player.getGameMode() == GameMode.SURVIVAL;

        // If the player was put in survival (presumably by WorldGuard), do this...
        // Use Duels API to tell if the player whose game mode has changed is spectating
        // a duel.
        if (!condition) {

            return;

        }

        // Inform the player that they will stop spectating the match.
        UtilitiesOG.trueogMessage(player,
                "<gray>[<dark_green>True<red>OG<gray>] <gold>Out of bounds! Your Duel spectating session has ended.");

        // Stop the player from spectating the match.
        duelsAPI.getSpectateManager().stopSpectating(player);

    }

}