package dev.bence.poluxlobby.listeners;

import dev.bence.poluxlobby.PoluxLobby;
import dev.bence.poluxlobby.libaries.ItemBuilder;
import dev.bence.poluxlobby.utils.ChatUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinListener implements Listener {

    PoluxLobby main = PoluxLobby.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        player.getInventory().clear();

        String joinMessage = PlaceholderAPI.setPlaceholders(player, ChatUtils.format(main.getMessagesFile().getString("join-message")));


        ItemStack joinItem = new ItemBuilder(Material.getMaterial(main.getSelectorFile().getString("server-selector-item")))
                .setName(ChatUtils.format(main.getSelectorFile().getString("server-selector.name")))
                .setLore(ChatUtils.format(main.getSelectorFile().getStringList("server-selector.lore")))
                .setAmount(main.getSelectorFile().getInt("server-selector.amount"))
                .build();

        ItemStack playerItem = new ItemBuilder(Material.getMaterial(main.getPlayerFile().getString("player-settings-item")))
                .setName(ChatUtils.format(main.getPlayerFile().getString("player-settings.name")))
                .setLore(ChatUtils.format(main.getPlayerFile().getStringList("player-settings.lore")))
                .setAmount(main.getPlayerFile().getInt("player-settings.amount"))
                .build();

        if (player.hasPermission("poluxmc.fly")) {
            ItemStack flyItem = new ItemBuilder(Material.FEATHER)
                    .setName(ChatUtils.format(main.getConfig().getString("fly-item.name")))
                    .setLore(ChatUtils.format(main.getConfig().getStringList("fly-item.lore")))
                    .setAmount(main.getConfig().getInt("fly-item.amount"))
                    .build();
            player.getInventory().setItem(main.getConfig().getInt("fly-item.slot"), flyItem);
        }

        ItemStack lobbySelector = new ItemBuilder(Material.getMaterial(main.getLobbyFile().getString("lobby-selector-item")))
                .setName(ChatUtils.format(main.getLobbyFile().getString("lobby-selector.name")))
                .setLore(ChatUtils.format(main.getLobbyFile().getStringList("lobby-selector.lore")))
                .setAmount(main.getLobbyFile().getInt("lobby-selector.amount"))
                .build();



        ItemStack hideItem = new ItemBuilder(Material.LIME_DYE)
                .setName(ChatUtils.format(main.getMessagesFile().getString("zichtbaarheid-aan")))
                .build();


        e.setJoinMessage(joinMessage);
        player.getInventory().setItem(7, hideItem);
        player.getInventory().setItem(main.getPlayerFile().getInt("player-settings.slot"), playerItem);
        player.getInventory().setItem(main.getSelectorFile().getInt("server-selector.slot"), joinItem);
        player.getInventory().setItem(main.getLobbyFile().getInt("lobby-selector.slot"), lobbySelector);

    }
}


