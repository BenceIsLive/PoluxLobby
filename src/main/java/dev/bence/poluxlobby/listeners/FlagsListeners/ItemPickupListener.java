package dev.bence.poluxlobby.listeners.FlagsListeners;

import dev.bence.poluxlobby.PoluxLobby;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class ItemPickupListener implements Listener {

    PoluxLobby main = PoluxLobby.getInstance();

    @EventHandler
    public void onPickUp(EntityPickupItemEvent e) {

        if (main.getConfig().getBoolean("item-pickup")) {
            e.setCancelled(false);
        } else if (!main.getConfig().getBoolean("item-pickup")) {
            e.setCancelled(true);
        }
    }
}
