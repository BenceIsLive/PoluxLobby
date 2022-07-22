package dev.bence.poluxlobby.listeners.JoinListeners;

import dev.bence.poluxlobby.PoluxLobby;
import dev.bence.poluxlobby.menus.SelectorMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class ServerSelector implements Listener {

    PoluxLobby main = PoluxLobby.getInstance();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (e.getHand().equals(EquipmentSlot.HAND)) {
            if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.getMaterial(main.getSelectorFile().getString("server-selector-item")))) {

                new SelectorMenu(player);
            }


        }
    }
}


