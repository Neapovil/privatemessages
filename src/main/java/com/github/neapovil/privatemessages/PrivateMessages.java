package com.github.neapovil.privatemessages;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import com.electronwill.nightconfig.core.file.FileConfig;
import com.github.neapovil.privatemessages.command.MessageCommand;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;

public final class PrivateMessages extends JavaPlugin
{
    private static PrivateMessages instance;
    private FileConfig messages;
    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    @Override
    public void onEnable()
    {
        instance = this;

        this.saveResource("messages.json", false);

        this.messages = FileConfig.builder(new File(this.getDataFolder(), "messages.json"))
                .autoreload()
                .autosave()
                .build();

        this.messages.load();

        MessageCommand.register();
    }

    @Override
    public void onDisable()
    {
    }

    public static PrivateMessages getInstance()
    {
        return instance;
    }

    public Component getMessageComponent(String path, String playerName, String content)
    {
        final String message = this.messages.get("messages." + path);
        return this.miniMessage.deserialize(message, Placeholder.parsed("player_name", playerName), Placeholder.parsed("content", content));
    }
}
