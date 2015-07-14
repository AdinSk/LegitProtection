package me.Adin.Legit;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable() {
	this.saveDefaultConfig();
	this.getServer().getPluginManager().registerEvents(new LegitListener(this), this);
	log.info("[AntiCheat] Plugin enabled... VERSION: 1.0 BETA");
	log.info("[AntiCheat] Plugin by Adin_SK");
	}
	
	public void onDisable() {
	log.info("[AntiCheat] Plugin disabled... VERSION: 1.0 BETA");
	log.info("[AntiCheat] Plugin by Adin_SK");
		
		
	}
	
}
