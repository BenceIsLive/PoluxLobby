package dev.bence.poluxlobby.listeners.FlagsListener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropListener implements Listener {


    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        int slot = 8; // Any number 0-8 depending on what slot you want to block. 0 is for the first slot. 1, the second, and so on.
        if (player.getInventory().getHeldItemSlot() <= 9) {
            event.setCancelled(true);
        }

    }
}
