package me.Adin.Legit;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	Logger log = Logger.getLogger("Minecraft");

	public void onEnable() {
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new LegitListener(this), this);
		log.log(Level.INFO, "[AntiCheat] Plugin enabled... VERSION: " + getDescription().getVersion());
		log.log(Level.INFO, "[AntiCheat] Plugin by Adin_SK");
	}

	public void onDisable() {
		saveConfig();
		log.log(Level.INFO, "[AntiCheat] Plugin disabled... VERSION: " + getDescription().getVersion());
		log.log(Level.INFO, "[AntiCheat] Plugin by Adin_SK");

	}

}
