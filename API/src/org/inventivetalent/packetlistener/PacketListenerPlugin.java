package org.inventivetalent.packetlistener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.inventivetalent.packetlistener.metrics.Metrics;
import org.inventivetalent.update.spiget.SpigetUpdate;
import org.inventivetalent.update.spiget.UpdateCallback;
import org.inventivetalent.update.spiget.comparator.VersionComparator;

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

		new Metrics(this, 225);

		packetListenerAPI.init(this);
	}

	@Override
	public void onDisable() {
		packetListenerAPI.disable(this);
	}

}
