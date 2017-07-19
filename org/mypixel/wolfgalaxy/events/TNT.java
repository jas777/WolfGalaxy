package org.mypixel.wolfgalaxy.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class TNT implements Listener {

    @EventHandler

    public void TNTBlocker(BlockPlaceEvent event){

        Block block = event.getBlock();

        Player player = event.getPlayer();

        if(!player.hasPermission("tnt.bypass")){

            if(block.getType().equals(Material.TNT)){

                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You can't place TNT on this server");

            }

        }

    }

}
