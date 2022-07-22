package dev.bence.poluxlobby.listeners.FlagsListeners;

import dev.bence.poluxlobby.PoluxLobby;
import dev.bence.poluxlobby.utils.ChatUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    PoluxLobby main = PoluxLobby.getInstance();

    @EventHandler
    public void onBreak(BlockBreakEvent e) {


        if (main.getConfig().getBoolean("block-break")) {
            e.setCancelled(false);
        } else if (!main.getConfig().getBoolean("block-break")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatUtils.format(main.getMessagesFile().getString("prefix")) + ChatUtils.format(main.getMessagesFile().getString("block-break-off")));
        }
    }
}
