# CaptureTheFlag

CaptureTheFlag is a custom mini-game plugin for Paper/Spigot servers.  
It provides a fully functional **Red vs Blue Capture the Flag game mode**, with flag capturing, scoring, and team assignment built directly into Minecraft.

## Overview
Players are randomly assigned to the **Red** or **Blue** team when the game starts.  
Each team must defend their own pyramid flag while attempting to steal the opponent’s flag and return it to their scoring location.  

The plugin tracks team points, updates player tab lists with current scores, and manages flag capture and scoring logic seamlessly.

## Features
- Random team assignment (`/startCTF`).  
- Teleports players to their team pyramids at the start of the game.  
- Interactive flag capture system (using wool blocks to represent flags).  
- Score points by returning the enemy’s flag to your base.  
- Automatic scoreboard updates in the player tab list.  
- Supports multiple rounds with `/endCTF` and `/startCTF`.  

## Commands
| Command      | Description                           |
|--------------|---------------------------------------|
| `/startCTF`  | Starts a Capture the Flag game, assigns teams, and teleports players. |
| `/endCTF`    | Ends the current Capture the Flag game. |

## Technical
- **Minecraft:** Spigot/Paper 1.21.1  
- **Language:** Java 21  
- **Build Tool:** Maven  

## Installation
1. Build the plugin with Maven (`mvn clean package`) or use a precompiled JAR.  
2. Place the JAR into your server’s `plugins/` directory.  
3. Start the server.  
4. Use `/startCTF` to assign players to teams and begin the game.  

---

## License & Usage
This plugin was developed by **Penta** and is shown here for demonstration purposes. Rights reserved.
