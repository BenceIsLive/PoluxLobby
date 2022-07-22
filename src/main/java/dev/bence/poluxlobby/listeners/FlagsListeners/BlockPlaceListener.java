package dev.bence.poluxlobby.listeners.FlagsListeners;

import dev.bence.poluxlobby.PoluxLobby;
import dev.bence.poluxlobby.utils.ChatUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    PoluxLobby main = PoluxLobby.getInstance();

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {

        if (main.getConfig().getBoolean("block-place")) {
            e.setCancelled(false);
        } else if (!main.getConfig().getBoolean("block-place")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatUtils.format(main.getMessagesFile().getString("prefix")) + ChatUtils.format(main.getMessagesFile().getString("block-place-off")));
        }
    }
}
