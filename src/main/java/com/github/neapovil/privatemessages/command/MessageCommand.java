package com.github.neapovil.privatemessages.command;

import org.bukkit.entity.Player;

import com.github.neapovil.privatemessages.PrivateMessages;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.EntitySelectorArgument;
import dev.jorel.commandapi.arguments.GreedyStringArgument;

public final class MessageCommand
{
    private static final PrivateMessages plugin = PrivateMessages.getInstance();

    public static final void register()
    {
        new CommandAPICommand("message")
                .withPermission("privatemessages.command.message")
                .withArguments(new EntitySelectorArgument("player", EntitySelectorArgument.EntitySelector.ONE_PLAYER))
                .withArguments(new GreedyStringArgument("content"))
                .executesPlayer((player, args) -> {
                    final Player target = (Player) args[0];
                    final String content = (String) args[1];

                    player.sendMessage(plugin.getMessageComponent("sender", target.getName(), content));
                    target.sendMessage(plugin.getMessageComponent("receiver", player.getName(), content));
                })
                .register();
    }
}
