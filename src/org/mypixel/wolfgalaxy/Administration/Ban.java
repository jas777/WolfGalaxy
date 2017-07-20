package org.mypixel.wolfgalaxy.Administration;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.mypixel.wolfgalaxy.Main;
import org.mypixel.wolfgalaxy.data.BanReason.Perm;

import java.awt.*;
import java.util.*;

public class Ban implements Listener, CommandExecutor {

    private Inventory perminv;
    private Inventory tempinv;
    Inventory inv;
    ArrayList<String> lore = new ArrayList<String>();
    private Plugin plugin = Main.getPlugin(Main.class);

    public static Map<UUID, String> mtb = new WeakHashMap<UUID, String>();

    public Ban(Main m) {

        inv = Bukkit.createInventory(null, 9, "Ban Menu");
        {

            inv.setItem(0, blank);
            inv.setItem(1, blank);
            inv.setItem(2, iswrd);
            inv.setItem(3, blank);
            inv.setItem(4, blank);
            inv.setItem(5, blank);
            inv.setItem(6, barrier);
            inv.setItem(7, blank);
            inv.setItem(8, blank);

        }

        perminv = Bukkit.createInventory(null, 9, "§cPermanent Bans");
        {

            perminv.setItem(0, barrier1);
            perminv.setItem(1, barrier2);
            perminv.setItem(2, barrier3);
            perminv.setItem(3, barrier4);
            perminv.setItem(4, barrier5);
            perminv.setItem(5, barrier6);
            perminv.setItem(6, barrier7);
            perminv.setItem(7, barrier8);
            perminv.setItem(8, barrier9);

        }

        tempinv = Bukkit.createInventory(null, 9, "§cTemporary Bans");
        {

            tempinv.setItem(0, iswrd1);
            tempinv.setItem(1, iswrd2);
            tempinv.setItem(2, iswrd3);
            tempinv.setItem(3, iswrd4);
            tempinv.setItem(4, iswrd5);
            tempinv.setItem(5, iswrd6);
            tempinv.setItem(6, iswrd7);
            tempinv.setItem(7, iswrd8);
            tempinv.setItem(8, iswrd9);

        }

    }


    ItemStack bone = new ItemStack(Material.COMPASS, 1);

    {

        ItemMeta bn = bone.getItemMeta();
        bn.setDisplayName("Ban Menu");
        bone.setItemMeta(bn);

    }

    ItemStack barrier = new ItemStack(Material.BARRIER, 1);

    {

        ItemMeta brr = barrier.getItemMeta();
        brr.setDisplayName("§cPermanent Ban");
        barrier.setItemMeta(brr);

    }

    ItemStack barrier1 = new ItemStack(Material.BARRIER, 1);

    {

        ItemMeta brr1 = barrier1.getItemMeta();
        brr1.setDisplayName("§cPermanent Ban");
        lore = new ArrayList<String>();
        lore.add(ChatColor.RED + "Cheating: X-Ray");
        brr1.setLore(lore);
        barrier1.setItemMeta(brr1);

    }

    ItemStack barrier2 = new ItemStack(Material.BARRIER, 1);

    {

        ItemMeta brr2 = barrier2.getItemMeta();
        brr2.setDisplayName("§cPermanent Ban");
        barrier2.setItemMeta(brr2);

    }

    ItemStack barrier3 = new ItemStack(Material.BARRIER, 1);

    {

        ItemMeta brr3 = barrier3.getItemMeta();
        brr3.setDisplayName("§cPermanent Ban");
        barrier3.setItemMeta(brr3);

    }

    ItemStack barrier4 = new ItemStack(Material.BARRIER, 1);

    {

        ItemMeta brr4 = barrier4.getItemMeta();
        brr4.setDisplayName("§cPermanent Ban");
        barrier4.setItemMeta(brr4);

    }

    ItemStack barrier5 = new ItemStack(Material.BARRIER, 1);

    {

        ItemMeta brr5 = barrier5.getItemMeta();
        brr5.setDisplayName("§cPermanent Ban");
        barrier5.setItemMeta(brr5);

    }

    ItemStack barrier6 = new ItemStack(Material.BARRIER, 1);

    {

        ItemMeta brr6 = barrier6.getItemMeta();
        brr6.setDisplayName("§cPermanent Ban");
        barrier6.setItemMeta(brr6);

    }

    ItemStack barrier7 = new ItemStack(Material.BARRIER, 1);

    {

        ItemMeta brr7 = barrier7.getItemMeta();
        brr7.setDisplayName("§cPermanent Ban");
        barrier7.setItemMeta(brr7);

    }

    ItemStack barrier8 = new ItemStack(Material.BARRIER, 1);

    {

        ItemMeta brr8 = barrier8.getItemMeta();
        brr8.setDisplayName("§cPermanent Ban");
        barrier8.setItemMeta(brr8);

    }

    ItemStack barrier9 = new ItemStack(Material.BARRIER, 1);

    {

        ItemMeta brr9 = barrier9.getItemMeta();
        brr9.setDisplayName("§cPermanent Ban");
        barrier9.setItemMeta(brr9);

    }

    ItemStack iswrd = new ItemStack(Material.IRON_SWORD, 1);

    {

        ItemMeta isw = iswrd.getItemMeta();
        isw.setDisplayName("§cTemporary Ban");
        iswrd.setItemMeta(isw);

    }

    ItemStack iswrd1 = new ItemStack(Material.IRON_SWORD, 1);

    {

        ItemMeta isw1 = iswrd1.getItemMeta();
        isw1.setDisplayName("Temporary Ban1");
        iswrd1.setItemMeta(isw1);

    }

    ItemStack iswrd2 = new ItemStack(Material.IRON_SWORD, 1);

    {

        ItemMeta isw2 = iswrd2.getItemMeta();
        isw2.setDisplayName("§cTemporary Ban2");
        iswrd2.setItemMeta(isw2);

    }

    ItemStack iswrd3 = new ItemStack(Material.IRON_SWORD, 1);

    {

        ItemMeta isw3 = iswrd3.getItemMeta();
        isw3.setDisplayName("§cTemporary Ban3");
        iswrd3.setItemMeta(isw3);

    }

    ItemStack iswrd4 = new ItemStack(Material.IRON_SWORD, 1);

    {

        ItemMeta isw4 = iswrd4.getItemMeta();
        isw4.setDisplayName("§cTemporary Ban4");
        iswrd4.setItemMeta(isw4);

    }

    ItemStack iswrd5 = new ItemStack(Material.IRON_SWORD, 1);

    {

        ItemMeta isw5 = iswrd5.getItemMeta();
        isw5.setDisplayName("§cTemporary Ban5");
        iswrd5.setItemMeta(isw5);

    }

    ItemStack iswrd6 = new ItemStack(Material.IRON_SWORD, 1);

    {

        ItemMeta isw6 = iswrd6.getItemMeta();
        isw6.setDisplayName("§cTemporary Ban6");
        iswrd6.setItemMeta(isw6);

    }

    ItemStack iswrd7 = new ItemStack(Material.IRON_SWORD, 1);

    {

        ItemMeta isw7 = iswrd7.getItemMeta();
        isw7.setDisplayName("§cTemporary Ban7");
        iswrd7.setItemMeta(isw7);

    }

    ItemStack iswrd8 = new ItemStack(Material.IRON_SWORD, 1);

    {

        ItemMeta isw8 = iswrd8.getItemMeta();
        isw8.setDisplayName("§cTemporary Ban8");
        iswrd8.setItemMeta(isw8);

    }

    ItemStack iswrd9 = new ItemStack(Material.IRON_SWORD, 1);

    {

        ItemMeta isw9 = iswrd9.getItemMeta();
        isw9.setDisplayName("§cTemporary Ban9");
        iswrd9.setItemMeta(isw9);

    }

    ItemStack blank = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 8);

    {
        ItemMeta im = blank.getItemMeta();
        im.setDisplayName(" ");
        blank.setItemMeta(im);
    }


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        if (sender instanceof Player) {
            if (label.equalsIgnoreCase("wban"))
                if (player.hasPermission("wban.use")) {
                    ((Player) sender).openInventory(inv);


                }

            String s;
            s = args[0];

            String toBan1 = "";

            Ban.mtb.put(((Player) sender).getUniqueId(), toBan1);

        } else {

            player.sendMessage(ChatColor.RED + "You have no permission to ban pepole!");

        }
        return false;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.COMPASS)
                && e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(bone.getItemMeta().getDisplayName())) {


            e.getPlayer().openInventory(inv);
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Inventory in = e.getInventory();
        if (inv == null) {
            return;
        }
        if (inv != null) {
            if (!inv.getName().equals(in.getTitle())) {
                return;
            }
            if (e.getCurrentItem() == null) {
                return;
            } else {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(inv.getTitle())) {


                }
            }
        }
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();
            if (e.getCurrentItem().getItemMeta() != null) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(barrier.getItemMeta().getDisplayName())) {
                    p.openInventory(perminv);
                    e.setCancelled(true);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(iswrd.getItemMeta().getDisplayName())) {
                    p.closeInventory();
                    p.openInventory(tempinv);
                    e.setCancelled(true);
                }
            } else {
                e.setCancelled(true);
                p.openInventory(e.getInventory());
            }


        }

        if (inv == null) {
            return;
        }
        if (inv != null) {
            if (!inv.getName().equals(tempinv.getTitle())) {
                return;
            }
            if (e.getCurrentItem() == null) {
                return;
            } else {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(iswrd1.getItemMeta().getDisplayName()) || equals(iswrd2.getItemMeta().getDisplayName()) || equals(iswrd3.getItemMeta().getDisplayName()) || equals(iswrd4.getItemMeta().getDisplayName()) || equals(iswrd5.getItemMeta().getDisplayName()) || equals(iswrd6.getItemMeta().getDisplayName()) || equals(iswrd7.getItemMeta().getDisplayName()) || equals(iswrd8.getItemMeta().getDisplayName()) || equals(iswrd9.getItemMeta().getDisplayName())) {


                }
            }


            if (e.getWhoClicked() instanceof Player) {

                Player p = (Player) e.getWhoClicked();

                if (e.getCurrentItem().getItemMeta() != null) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(iswrd1.getItemMeta().getDisplayName())) {
                        String ci = e.getCurrentItem().getItemMeta().getDisplayName();

                        String rXRay = "ChatColor.RED + \"You have beeen permanently banned\\n\" + ChatColor.YELLOW + \"Reason:\" + ChatColor.DARK_GRAY + \"Using X-Ray";
                        p.kickPlayer(rXRay);
                        Bukkit.getBanList(BanList.Type.NAME).addBan(p.getName(), rXRay, null, e.getWhoClicked().getName());
                        e.setCancelled(true);
                        p.closeInventory();

                    }

                } else{

                    p.sendMessage("Nie dziala");
                    e.setCancelled(true);

                }

            }

        }

    }
}