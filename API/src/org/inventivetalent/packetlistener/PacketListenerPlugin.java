package org.inventivetalent.packetlistener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PacketListenerPlugin extends JavaPlugin {

	private final PacketListenerAPI packetListenerAPI = new PacketListenerAPI();

	@Override
	public void onLoad() {
		packetListenerAPI.load();
	}

	@Override
	public void onEnable() {
		if (!packetListenerAPI.injected) {
			getLogger().warning("Injection failed. Disabling...");
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}

		packetListenerAPI.init(this);
	}

	@Override
	public void onDisable() {
		packetListenerAPI.disable(this);
	}

}
