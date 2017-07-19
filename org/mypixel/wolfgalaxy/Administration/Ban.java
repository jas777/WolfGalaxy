package org.mypixel.wolfgalaxy.Administration;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Ban implements Listener, CommandExecutor {

    Inventory inv;
    Inventory perminv;
    Inventory tempinv;

    public Ban() {

        inv = Bukkit.createInventory(null, 5, "§cBan Menu");
        {

            inv.setItem(0, blank);
            inv.setItem(1, blank);
            inv.setItem(2, iswrd);
            inv.setItem(3, blank);
            inv.setItem(4, barrier);
            inv.setItem(5, blank);

        }

        perminv = Bukkit.createInventory(null, 9, "§cPermanent Bans")

    }


    ItemStack bone = new ItemStack(Material.BONE, 1);

    {

        ItemMeta bn = bone.getItemMeta();
        bn.setDisplayName("§cBan Menu");
        bone.setItemMeta(bn);

    }

    ItemStack barrier = new ItemStack(Material.BARRIER, 1);

    {

        ItemMeta brr = barrier.getItemMeta();
        brr.setDisplayName("§cPermanent Ban");
        bone.setItemMeta(brr);

    }

    ItemStack iswrd = new ItemStack(Material.IRON_SWORD, 1);

    {

        ItemMeta isw = iswrd.getItemMeta();
        isw.setDisplayName("§cTemporary Ban");
        bone.setItemMeta(isw);

    }

    ItemStack blank = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);

    {
        ItemMeta im = blank.getItemMeta();
        im.setDisplayName(" ");
        blank.setItemMeta(im);
    }


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender

        if(label.equalsIgnoreCase("ban"))
            if(player.getInventory().containsAtLeast(bone, 1)){

            player.getPlayer().getInventory().addItem(bone);

            }

        return false;
    }



}
