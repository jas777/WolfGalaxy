package org.mypixel.wolfgalaxy.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {

    @EventHandler

    public void onPlayerLeave(PlayerQuitEvent event) {

        Player player = event.getPlayer();

        event.setQuitMessage(ChatColor.DARK_GRAY + "Player" + ChatColor.RED + " " + player.getName() + ChatColor.DARK_GRAY + " has left the server.");

    }

}
