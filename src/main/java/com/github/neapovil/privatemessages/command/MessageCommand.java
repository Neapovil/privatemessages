package com.github.neapovil.privatemessages.command;

import org.bukkit.entity.Player;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import dev.jorel.commandapi.arguments.PlayerArgument;
import net.md_5.bungee.api.ChatColor;

public final class MessageCommand
{
    public static final void register()
    {
        new CommandAPICommand("message")
                .withPermission("privatemessages.command.message")
                .withArguments(new PlayerArgument("player"))
                .withArguments(new GreedyStringArgument("content"))
                .executes((sender, args) -> {
                    final Player player = (Player) args[0];
                    final String content = (String) args[1];

                    sender.sendMessage(ChatColor.GRAY + "[me -> " + player.getName() + "]: " + ChatColor.RESET + content);
                    player.sendMessage(ChatColor.GREEN + "[" + sender.getName() + " -> me]: " + ChatColor.RESET + content);
                })
                .register();
    }
}
