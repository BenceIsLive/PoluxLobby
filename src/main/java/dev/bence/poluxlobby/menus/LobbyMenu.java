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

public class LobbyMenu {

    PoluxLobby main = PoluxLobby.getInstance();

    public LobbyMenu(Player player) {

        Inventory inv = Bukkit.createInventory(player, 27, ChatUtils.format(main.getLobbyFile().getString("lobby-selector-title")));

        for (String key : main.getLobbyFile().getConfigurationSection("items.").getKeys(false)) {
            ConfigurationSection keySection = main.getLobbyFile().getConfigurationSection("items.").getConfigurationSection(key);
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

