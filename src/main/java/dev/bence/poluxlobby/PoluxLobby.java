package dev.bence.poluxlobby;

import dev.bence.poluxlobby.listeners.ClickListeners.SelectorClick;
import dev.bence.poluxlobby.listeners.CustomListener.PlayerChangeServerEvent;
import dev.bence.poluxlobby.listeners.FlagsListener.ItemDropListener;
import dev.bence.poluxlobby.listeners.JoinListener;
import dev.bence.poluxlobby.listeners.JoinListeners.*;
import dev.bence.poluxlobby.listeners.QuitListener;
import dev.bence.poluxlobby.utils.DataFile;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PoluxLobby extends JavaPlugin {

    public static PoluxLobby instance;

    private DataFile messagesFile;
    private DataFile selectorFile;
    private DataFile playerFile;
    private DataFile lobbyFile;
    @Override
    public void onEnable() {

        instance = this;

        registerEvents();
        registerCommands();

        saveDefaultConfig();
        saveResource("messages.yml", false);
        saveResource("server-selector.yml", false);
        saveResource("player-settings.yml", false);
        saveResource("lobby-selector.yml", false);

        messagesFile = new DataFile("messages.yml", getDataFolder());
        selectorFile = new DataFile("server-selector.yml", getDataFolder());
        playerFile = new DataFile("player-settings.yml", getDataFolder());
        lobbyFile = new DataFile("lobby-selector.yml", getDataFolder());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static PoluxLobby getInstance() { return instance; }

    public DataFile getMessagesFile() { return messagesFile; }
    public DataFile getSelectorFile() { return selectorFile; }
    public DataFile getPlayerFile() { return playerFile; }
    public DataFile getLobbyFile() { return lobbyFile; }

    public void registerEvents() {
        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new ServerSelector(), this);
        pm.registerEvents(new PlayerSettings(), this);
        pm.registerEvents(new PlayerHide(), this);
        pm.registerEvents(new LobbySelector(), this);
        pm.registerEvents(new FlyItem(), this);
        pm.registerEvents(new ItemDropListener(), this);
        pm.registerEvents(new SelectorClick(), this);

    }
    public void registerCommands() {

    }
}
