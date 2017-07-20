package org.mypixel.wolfgalaxy.data.BanReason;

import org.bukkit.ChatColor;
import org.mypixel.wolfgalaxy.Administration.Ban;

import java.util.Map;
import java.util.WeakHashMap;

public class Perm {

    public static Map<String, String> permReason = new WeakHashMap<String, String>();


    String xRay = ChatColor.RED + "You have beeen permanently banned\n" + ChatColor.YELLOW + "Reason:" + ChatColor.DARK_GRAY + "Using X-Ray";
    String pvpHack = ChatColor.RED + "You have beeen permanently banned\n" + ChatColor.YELLOW + "Reason:" + ChatColor.DARK_GRAY + "PvP Hacking";

    String rXRay;


}
