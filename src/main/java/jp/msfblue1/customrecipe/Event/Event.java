package jp.msfblue1.customrecipe.Event;

import jp.msfblue1.customrecipe.CustomRecipe;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.ItemStack;

/**
 * Created by msfblue1 on 2017/12/19.
 */
public class Event implements Listener{
    CustomRecipe plugin;


    public Event(CustomRecipe me){
        this.plugin = me;
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onCreateItemWithTable(InventoryClickEvent e){
        if(e.isLeftClick()){
            if(e.getInventory().getType().equals(InventoryType.WORKBENCH)){
                if(e.getSlotType().equals(InventoryType.SlotType.CRAFTING)){
                    e.getInventory().setItem(0,new ItemStack(Material.TNT));
                    ((Player)e.getWhoClicked()).updateInventory();
                }
            }
        }
        if(e.isRightClick()){
            if(e.getInventory().getType().equals(InventoryType.WORKBENCH)){
                if(e.getSlotType().equals(InventoryType.SlotType.CRAFTING)){
                    e.getInventory().setItem(0,new ItemStack(Material.TNT));
                    ((Player)e.getWhoClicked()).updateInventory();
                }
            }
        }
    }
}
