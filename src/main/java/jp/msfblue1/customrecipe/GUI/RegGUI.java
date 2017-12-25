package jp.msfblue1.customrecipe.GUI;

import jp.msfblue1.customrecipe.CustomRecipe;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

/**
 * Created by msfblue1 on 2017/12/19.
 */
public class RegGUI {

    ItemStack outofrange = new ItemStack(Material.STAINED_GLASS_PANE);
    ItemStack save = new ItemStack(Material.EMERALD_BLOCK);
    ItemStack cancel = new ItemStack(Material.BARRIER);

    public void openGUI(Player player){
        Inventory inv;
        inv = getGUI();
        player.openInventory(inv);
        final Listener[] listener = new Listener[1];
        listener[0] = new Listener() {
            @EventHandler
            public void onClose(InventoryCloseEvent e) {
                if (inv.equals(e.getInventory())) {
                    HandlerList.unregisterAll(listener[0]);
                }
            }

            @EventHandler
            public void onPlayerQuit(PlayerQuitEvent e) {
                HandlerList.unregisterAll(listener[0]);
            }

            @EventHandler
            public void onClick(InventoryClickEvent e) {
                if(e.getClickedInventory() != null){
                    if (inv.equals(e.getInventory()) && e.getClickedInventory().getType().equals(InventoryType.CHEST)) {
                        switch (e.getSlot()) {
                            case 12:
                            case 13:
                            case 14:
                            case 21:
                            case 22:
                            case 23:
                            case 25:
                            case 30:
                            case 31:
                            case 32:
                                break;
                            case 51:
                                e.getWhoClicked().closeInventory();
                                HandlerList.unregisterAll(listener[0]);
                                e.getWhoClicked().sendMessage(ChatColor.YELLOW+"レシピ登録を破棄しました");
                                break;
                            case 53:
                                e.getWhoClicked().closeInventory();
                                HandlerList.unregisterAll(listener[0]);
                                e.getWhoClicked().sendMessage(ChatColor.GREEN+"レシピを登録しました");
                                break;
                            default:
                                e.setCancelled(true);
                                break;
                        }
                    }
                }
            }

            @EventHandler
            public void onSendItem(InventoryMoveItemEvent e){
                if(e.getDestination() != null && inv.equals(e.getDestination())){
                    int[] slots = new int[]{12,13,14,21,22,23,25,30,31,32};
                    for (Integer count : slots){

                    }
                }
            }
        };
        Bukkit.getPluginManager().registerEvents(listener[0], CustomRecipe.plugin);
    }
    public Inventory getGUI(){

        Inventory gui = Bukkit.createInventory(null,54,"レシピ登録画面");
        outofrange.setDurability(Short.valueOf("0"));
        outofrange.setAmount(1);
        ItemMeta itemMeta = outofrange.getItemMeta();
        itemMeta.setDisplayName(ChatColor.STRIKETHROUGH+""+ChatColor.GRAY+"範囲外");
        outofrange.setItemMeta(itemMeta);
        itemMeta = save.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN+"登録する");
        save.setItemMeta(itemMeta);
        save.setAmount(1);
        itemMeta = cancel.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED+"キャンセル");
        cancel.setItemMeta(itemMeta);
        cancel.setAmount(1);
        for (int i = 0; i < 54; i++) {
            //12~14 21~23 25 30~32 48 50
            switch (i){
                case 12:
                case 13:
                case 14:
                case 21:
                case 22:
                case 23:
                case 25:
                case 30:
                case 31:
                case 32:
                    gui.setItem(i,null);
                    break;
                case 51:
                    gui.setItem(i,cancel);
                    break;
                case 53:
                    gui.setItem(i,save);
                    break;
                default:
                    gui.setItem(i,outofrange);
                    break;
            }
        }
        return gui;
    }
}
