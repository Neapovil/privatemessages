package com.github.neapovil.privatemessages;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.neapovil.privatemessages.command.MessageCommand;

public final class PrivateMessages extends JavaPlugin
{
    private static PrivateMessages instance;

    @Override
    public void onEnable()
    {
        instance = this;

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
}
