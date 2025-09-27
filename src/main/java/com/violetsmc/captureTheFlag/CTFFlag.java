package com.violetsmc.captureTheFlag;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class CTFFlag implements Listener {

    private final Plugin plugin;
    private final Location redFlagLocation; // Location of the Red flag
    private final Location blueFlagLocation; // Location of the Blue flag
    private final Location redScoreLocation; // Scoring location for Red team
    private final Location blueScoreLocation; // Scoring location for Blue team

    public CTFFlag(Plugin plugin, Location redFlagLocation, Location blueFlagLocation,
                   Location redScoreLocation, Location blueScoreLocation) {
        this.plugin = plugin;
        this.redFlagLocation = redFlagLocation;
        this.blueFlagLocation = blueFlagLocation;
        this.redScoreLocation = redScoreLocation;
        this.blueScoreLocation = blueScoreLocation;

        // Register this class as an event listener
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        // Check if the player interacts with the Red flag
        if (player.getLocation().distance(redFlagLocation) < 2) {
            if (CTFCommand.playerTeams.get(player).equals("Blue")) {
                // Player from the Blue team captures the Red flag
                player.sendMessage("You have captured the Red flag!");
                player.getInventory().addItem(new ItemStack(Material.RED_WOOL, 1)); // Add red wool to inventory
            } else {
                player.sendMessage("You cannot capture your own flag!");
            }
        }

        // Check if the player interacts with the Blue flag
        if (player.getLocation().distance(blueFlagLocation) < 2) {
            if (CTFCommand.playerTeams.get(player).equals("Red")) {
                // Player from the Red team captures the Blue flag
                player.sendMessage("You have captured the Blue flag!");
                player.getInventory().addItem(new ItemStack(Material.BLUE_WOOL, 1)); // Add blue wool to inventory
            } else {
                player.sendMessage("You cannot capture your own flag!");
            }
        }

        // Check if the player is returning to the scoring location to score a point
        if (player.getLocation().distance(redScoreLocation) < 2) {
            if (player.getInventory().contains(Material.BLUE_WOOL)) {
                player.getInventory().removeItem(new ItemStack(Material.BLUE_WOOL, 1));
                player.sendMessage("You have scored a point for the Red team!");
                CaptureTheFlag.redTeamPoints++; // Increment Red team points
                CaptureTheFlag.updateTabList(); // Update scoreboard
            }
        }

        if (player.getLocation().distance(blueScoreLocation) < 2) {
            if (player.getInventory().contains(Material.RED_WOOL)) {
                player.getInventory().removeItem(new ItemStack(Material.RED_WOOL, 1));
                player.sendMessage("You have scored a point for the Blue team!");
                CaptureTheFlag.blueTeamPoints++; // Increment Blue team points
                CaptureTheFlag.updateTabList(); // Update scoreboard
            }
        }
    }
}
