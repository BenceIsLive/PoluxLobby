package dev.bence.poluxlobby.menus;

import dev.bence.poluxlobby.PoluxLobby;
import dev.bence.poluxlobby.libaries.ItemBuilder;
import dev.bence.poluxlobby.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SelectorMenu {

    PoluxLobby main = PoluxLobby.getInstance();

    public SelectorMenu(Player player) {

        Inventory inv = Bukkit.createInventory(player, 27, ChatUtils.format(main.getSelectorFile().getString("server-selector-title")));

        for (String key : main.getSelectorFile().getConfigurationSection("items.").getKeys(false)) {
            ConfigurationSection keySection = main.getSelectorFile().getConfigurationSection("items.").getConfigurationSection(key);
            int slot = keySection.getInt("slot");
            ItemStack item = new ItemBuilder(Material.getMaterial(keySection.getString("item")))
                    .setName(ChatUtils.format(keySection.getString("name")))
                    .setLore(ChatUtils.format(keySection.getStringList("lore")))
                    .build();
            inv.setItem(slot, item);

            player.openInventory(inv);
        }
    }
}


