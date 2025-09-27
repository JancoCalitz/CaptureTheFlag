package com.violetsmc.captureTheFlag;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.Location;

import static com.violetsmc.captureTheFlag.CTFCommand.playerTeams;

public class CaptureTheFlag extends JavaPlugin {

    public static int redTeamPoints = 0;  // Points for Red team
    public static int blueTeamPoints = 0; // Points for Blue team

    @Override
    public void onEnable() {
        getCommand("startCTF").setExecutor(new CTFCommand());
        getCommand("endCTF").setExecutor(new CTFCommand());

        // Initialize flags and score locations
        new CTFFlag(this,
                new Location(getServer().getWorld("world"), 1394, 97, -707), // Red flag coordinates
                new Location(getServer().getWorld("world"), 1488, 104, -707), // Blue flag coordinates
                new Location(getServer().getWorld("world"), 1394, 95, -713), // Red scoring location
                new Location(getServer().getWorld("world"), 1487, 101, -711) // Blue scoring location
        );
    }

    @Override
    public void onDisable() {
        // Any cleanup logic if needed
    }

    // Example method to get a player's team
    public static String getPlayerTeam(Player player) {
        return playerTeams.get(player); // Access the playerTeams map
    }

    // Public method to update the tab list for all players
    public static void updateTabList() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            String team = playerTeams.get(player);
            int score = team.equals("Red") ? redTeamPoints : blueTeamPoints; // Get the score for the player's team
            player.setPlayerListName(team + " Team | Points: " + score); // Update tab list name
        }
    }
}
