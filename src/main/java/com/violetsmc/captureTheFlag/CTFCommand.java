package com.violetsmc.captureTheFlag;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CTFCommand implements CommandExecutor {

    public static final Map<Player, String> playerTeams = new HashMap<>(); // Keep track of players' teams

    public CTFCommand() {
        // Initialize scores
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("startCTF")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be run by a player.");
                return true;
            }

            Player player = (Player) sender;
            String team = assignTeam();  // Assign teams
            playerTeams.put(player, team);
            player.sendMessage("You are on the " + team + " team!");

            // Display title to player indicating team
            player.sendTitle("Team: " + team, "", 10, 70, 20);
            teleportToPyramid(player, team);  // Teleport player to the respective pyramid
            CaptureTheFlag.updateTabList(); // Update tab list for all players

            return true;
        }
        return false;  // For commands not matched
    }

    private String assignTeam() {
        return new Random().nextBoolean() ? "Red" : "Blue";  // Randomly assign a team
    }

    private void teleportToPyramid(Player player, String team) {
        if (team.equals("Red")) {
            player.teleport(new Location(Bukkit.getWorld("world"), 1394, 97, -707));  // Red pyramid coordinates
        } else {
            player.teleport(new Location(Bukkit.getWorld("world"), 1488, 104, -707));  // Blue pyramid coordinates
        }
    }
}
