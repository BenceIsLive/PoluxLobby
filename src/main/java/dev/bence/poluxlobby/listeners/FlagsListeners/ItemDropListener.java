package dev.bence.poluxlobby.listeners.FlagsListeners;

import dev.bence.poluxlobby.PoluxLobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropListener implements Listener {

    PoluxLobby main = PoluxLobby.getInstance();

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (main.getConfig().getBoolean("item-drop")) {
            int slot = 8; // Any number 0-8 depending on what slot you want to block. 0 is for the first slot. 1, the second, and so on.
            if (player.getInventory().getHeldItemSlot() <= 9) {
                event.setCancelled(true);
            } else if (!main.getConfig().getBoolean("item-drop")) {
                event.setCancelled(false);
            }

        }
    }
}