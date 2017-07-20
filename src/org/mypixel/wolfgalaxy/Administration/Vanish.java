package org.mypixel.wolfgalaxy.Administration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Vanish implements Listener, CommandExecutor {

    private List<UUID> hidden = new ArrayList<UUID>();

    @SuppressWarnings("deprecation")
    public void onDisable(){
        for(UUID id : hidden){
            if(Bukkit.getPlayer(id) !=null){
                for(Player p : Bukkit.getOnlinePlayers()) p.showPlayer(Bukkit.getPlayer(id));
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        for(UUID id : hidden){
            if(Bukkit.getPlayer(id) !=null)  e.getPlayer().hidePlayer(Bukkit.getPlayer(id));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        if(hidden.contains(e.getPlayer().getUniqueId())) hidden.remove(e.getPlayer().getUniqueId());
    }

    @SuppressWarnings("deprecation")

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        Player player = (Player) sender;

        if(label.equalsIgnoreCase("hide")){
            Player p = (Player) sender;
            if(hidden.contains(p.getUniqueId())) return true;
            for(Player pl: Bukkit.getOnlinePlayers()){
                pl.hidePlayer(p);
                // 1.7.2 // ((CraftPlayer)pl).getHandle().playerConnection.sendPacket(new PacketPlayOutPlayerInfo(p.getPlayerListName(), false, 9999));
                // 1.7.10-1.8.x // PacketPlayOutPlayerInfo.removePlayer(((CraftPlayer)p).getHandle());
            }
            hidden.add(p.getUniqueId());
        }
        else if(label.equalsIgnoreCase("show")){
            Player p = (Player) sender;
            if(!hidden.contains(p.getUniqueId())) return true;
            for(Player pl: Bukkit.getOnlinePlayers()){
                pl.showPlayer(p);
                // 1.7.2 // ((CraftPlayer)pl).getHandle().playerConnection.sendPacket(new PacketPlayOutPlayerInfo(p.getPlayerListName(), true, 9999));
                // 1.7.10-1.8.x // PacketPlayOutPlayerInfo.addPlayer(((CraftPlayer)p).getHandle());
            }
            hidden.remove(p.getUniqueId());
        }
        return false;
    }

}
