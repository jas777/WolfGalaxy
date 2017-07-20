package org.mypixel.wolfgalaxy.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatControl implements Listener, CommandExecutor {

    public static boolean chat;

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        if (chat == false) {

            if (!event.getPlayer().hasPermission("chat.bypass")) {

                event.getPlayer().sendMessage(ChatColor.RED + "Chat is currently disabled!");
                event.setCancelled(true);

            }

        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("chat")) {

            if (sender.hasPermission("chat.control")) {

                if (args.length != 1) {

                    return true;

                }
                if (args[0].equalsIgnoreCase("on")) {

                    if (chat) {

                        Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "Chat has been " + ChatColor.GREEN + "enabled");
                        return true;

                    }
                    chat = true;

                }

                if (args[0].equalsIgnoreCase("off")) {

                    if (!chat) {

                        Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "Chat has been " + ChatColor.RED + "disabled");
                        return true;

                    }
                    chat = false;
                }
                if (args[0].equalsIgnoreCase("toggle")) {

                    chat = !chat;

                    if (chat) {

                        Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "Chat has been " + ChatColor.GREEN + "enabled");

                    } else {

                        Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "Chat has been " + ChatColor.RED + "disabled");

                    }

                }

                if (args[0].equalsIgnoreCase("clear")) {
                    int i = 0;
                    while (i < 101) {

                        Bukkit.broadcastMessage("");
                        i++;
                    }

                    Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "Chat has been cleared by " + ChatColor.RED + sender.getName());

                }

                if(!sender.hasPermission("chat.control")){

                    sender.sendMessage(ChatColor.RED + "You have no permission to control chat!");

                }

            }

        }
        return false;
    }
}
