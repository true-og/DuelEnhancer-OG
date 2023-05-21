package plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// Initialize command manager class.
public class CommandManager implements CommandExecutor {

	// Create instance of class for command runner.
	private static CommandManager instance;

	// Constructor for main class to get instance from.
	public static CommandManager getInstance() {

		return instance;

	}

	// Declare a new command.
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// If the command matches our criteria, do this...
		if (cmd.getName().equalsIgnoreCase("buy")) {

			// If the command executor is a player, do this...
			if (sender instanceof Player) {

				// Cast the sender to a player object safely.
				Player player = (Player) sender;

				// Send the available ranks to the user.
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&l-=-=-=-=- &2&lTrue&4OG &B&lDonation Store: &a&l-=-=-=-=-"));
				// TODO: Clickable ranks with info here.

			}
			// If the command executor is not a player, do this...
			else {

				// Deny console executions.
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "ERROR: The console cannot execute this command!"));

			}

		}

		// Healthy exit status.
		return true;

	}

}
