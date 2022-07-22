package dev.bence.poluxlobby.listeners;

import dev.bence.poluxlobby.PoluxLobby;
import dev.bence.poluxlobby.utils.ChatUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public class QuitListener implements Listener {

    PoluxLobby main = PoluxLobby.getInstance();
    public ArrayList<Player> hidden = new ArrayList<>();
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Player player = e.getPlayer();

        hidden.remove(player.getUniqueId());

        String leaveMessage = PlaceholderAPI.setPlaceholders(player, ChatUtils.format(main.getMessagesFile().getString("leave-message")));

        e.setQuitMessage(leaveMessage);
    }

}
