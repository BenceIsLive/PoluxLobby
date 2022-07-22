package dev.bence.poluxlobby.listeners.JoinListeners;

import dev.bence.poluxlobby.PoluxLobby;
import dev.bence.poluxlobby.utils.ChatUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class FlyItem implements Listener {


    ArrayList<UUID> fly = new ArrayList<>();
    PoluxLobby main = PoluxLobby.getInstance();


    @EventHandler
    public void onClick(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        Material feather = Material.FEATHER;

        ItemStack on = new ItemStack(Material.FEATHER);
        ItemMeta onMeta = on.getItemMeta();
        onMeta.setDisplayName(ChatUtils.format(main.getMessagesFile().getString("fly-aan")));

        ItemStack off = new ItemStack(Material.FEATHER);
        ItemMeta offMeta = off.getItemMeta();
        offMeta.setDisplayName(ChatUtils.format(main.getMessagesFile().getString("fly-uit")));

        if (e.getHand().equals(EquipmentSlot.HAND)) {
            if (item.getType() == feather) {
                e.setCancelled(true);

                if (fly.contains(player.getUniqueId())) {
                    fly.remove(player.getUniqueId());
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.getInventory().getItemInMainHand().setType(feather);
                    item.setItemMeta(offMeta);
                    player.updateInventory();
                    player.sendMessage(ChatUtils.format(main.getMessagesFile().getString("prefix") + main.getMessagesFile().getString("fly-aan-message")));
                } else {
                    if (e.getHand().equals(EquipmentSlot.HAND)) {
                        fly.add(player.getUniqueId());
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.getInventory().getItemInMainHand().setType(feather);
                        item.setItemMeta(onMeta);
                        player.updateInventory();
                        player.sendMessage(ChatUtils.format(main.getMessagesFile().getString("prefix") + main.getMessagesFile().getString("fly-uit-message")));
                    }

                }
            }

        }
    }
}
