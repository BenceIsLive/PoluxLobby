package dev.bence.poluxlobby.listeners.FlagsListeners;

import dev.bence.poluxlobby.PoluxLobby;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class FallDamagerListener implements Listener {

    PoluxLobby main = PoluxLobby.getInstance();

    @EventHandler
    public void onFallDamage(EntityDamageEvent e) {


        if (main.getConfig().getBoolean("fall-damage")) {
            e.setCancelled(false);
        } else if (!main.getConfig().getBoolean("fall-damage")) {
            e.setCancelled(true);
        }


    }

}
