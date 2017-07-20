package org.mypixel.wolfgalaxy;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.mypixel.wolfgalaxy.Administration.Ban;
import org.mypixel.wolfgalaxy.chat.ChatControl;
import org.mypixel.wolfgalaxy.chat.Join;
import org.mypixel.wolfgalaxy.chat.Leave;
import org.mypixel.wolfgalaxy.events.TNT;
import  org.mypixel.wolfgalaxy.Administration.Vanish;

import java.util.UUID;

public class Main extends JavaPlugin {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";



    @Override

    // Plugin enable

    public void onEnable() {

        System.out.println("[Wolf Galaxy] Enabling...");

        registerCommands();

        registerEvents();

    }

    // Plugin disable

    public void onDisable() {

        System.out.println("[Wolf Galaxy] Disabling...");

    }

    public void registerCommands() {

        getCommand("chat").setExecutor(new ChatControl());
        getCommand("wban").setExecutor(new Ban(this));
        getCommand("show").setExecutor(new Vanish());
        getCommand("hide").setExecutor(new Vanish());

    }

    public void registerEvents(){

        Bukkit.getPluginManager().registerEvents(new ChatControl(), this);
        Bukkit.getPluginManager().registerEvents(new Join(), this);
        Bukkit.getPluginManager().registerEvents(new Leave(), this);
        Bukkit.getPluginManager().registerEvents(new TNT(), this);
        Bukkit.getPluginManager().registerEvents(new Ban(this), this);
        Bukkit.getPluginManager().registerEvents(new Vanish(), this);

    }


}
