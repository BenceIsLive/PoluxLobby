package dev.bence.poluxlobby.listeners.JoinListeners;

import dev.bence.poluxlobby.PoluxLobby;
import dev.bence.poluxlobby.menus.LobbyMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class LobbySelector implements Listener {

    PoluxLobby main = PoluxLobby.getInstance();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        Material clock = Material.CLOCK;

        if (e.getHand().equals(EquipmentSlot.HAND)) {
            if (item.getType() == clock) {

                new LobbyMenu(player);
            }


        }
    }
}

