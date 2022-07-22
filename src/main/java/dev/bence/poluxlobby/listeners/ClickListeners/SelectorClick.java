package dev.bence.poluxlobby.listeners.ClickListeners;

import dev.bence.poluxlobby.PoluxLobby;
import dev.bence.poluxlobby.utils.BungeeUtils;
import dev.bence.poluxlobby.utils.ChatUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SelectorClick implements Listener {

    PoluxLobby main = PoluxLobby.getInstance();

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        e.setCancelled(true);

        if (e.getView().getTitle().equalsIgnoreCase(ChatUtils.format(main.getSelectorFile().getString("server-selector-title")))) {
            e.setCancelled(true);

            for (String key : main.getSelectorFile().getConfigurationSection("items.").getKeys(false)) {
                ConfigurationSection keySection = main.getSelectorFile().getConfigurationSection("items.").getConfigurationSection(key);
                int slot = keySection.getInt("slot");
                checkSlotStatus(e.getRawSlot(), slot, keySection, player);

            }

        }

    }

    public void checkSlotStatus(int slotNumber1, int slotNumber2, ConfigurationSection keySection, Player player) {
        if (slotNumber1 == slotNumber2) {
                BungeeUtils.connect(player, keySection.getString("server"));

        }
    }
}