package dev.bence.poluxlobby.listeners.JoinListeners;

import dev.bence.poluxlobby.PoluxLobby;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerSettings implements Listener {

    PoluxLobby main = PoluxLobby.getInstance();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (e.getHand().equals(EquipmentSlot.HAND)) {
            if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.getMaterial(main.getPlayerFile().getString("player-settings-item")))) {

//                new PlayerSettingsMenu(player);
            }


        }
    }
}

