package me.Adin.Legit;

import java.util.ArrayList;

import org.bukkit.Sound;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class LegitListener implements Listener {

	private Main plugin;
	private Configuration cfg = plugin.getConfig();
	private ArrayList<Player> players = new ArrayList<>();

	public LegitListener(Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		// Players
		Player p = e.getPlayer();
		String pn = p.getName();

		// Events
		players.add(p);
		if (cfg.getBoolean("EnableJoinMsg")) {
			p.sendMessage(cfg.getString("JoinMsg").replace("&", "§").replace("%player%", pn).replace("%line%", "\n"));
		}
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		// Players
		Player p = e.getPlayer();
		String msg = e.getMessage();

		// Events
		if (players.contains(p)) {
			if (msg.startsWith(cfg.getString("Text"))) {
				players.remove(p);
				p.sendMessage(cfg.getString("Succes").replace("&", "§").replace("%line%", "\n"));
				SoundSucces(p);
				e.setCancelled(true);
			} else {
				SoundNoSucces(p);
				p.sendMessage(cfg.getString("NoSucces").replace("&", "§").replace("%line%", "\n"));
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		// Players
		Player p = e.getPlayer();

		// Events
		if (players.contains(p)) {
			e.setCancelled(true);
		}
	}

	public void SoundSucces(Player p) {
		if (cfg.getBoolean("EnableSounds")) {
			p.playSound(p.getLocation(), Sound.valueOf(cfg.getString("SuccesSound")), 1, 1);
		}
	}

	public void SoundNoSucces(Player p) {
		if (cfg.getBoolean("EnableSounds")) {
			p.playSound(p.getLocation(), Sound.valueOf(cfg.getString("NoSuccesSound")), 1, 1);
		}
	}
}
