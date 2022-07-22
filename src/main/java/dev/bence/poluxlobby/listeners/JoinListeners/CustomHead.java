package dev.bence.poluxlobby.listeners.JoinListeners;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import dev.bence.poluxlobby.utils.ChatUtils;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class CustomHead implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {


    ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
    SkullMeta meta = (SkullMeta) skull.getItemMeta();
    meta.setDisplayName(ChatUtils.format("&7&oComing soon!"));

        GameProfile profile =  new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("texture", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTNkNzU3NWE2ZDhmZWZmYjIyNzgzZTFlMmI2ZGZiZTI5OTZmYWRiYzk3NzlmODhlNzQyYTAxMmM2MmFhIn19fQ=="));
        Field field;
        try {
            field = meta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(meta, profile);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        skull.setItemMeta(meta);

        event.getPlayer().getInventory().setItem(0, skull);


    }
}
