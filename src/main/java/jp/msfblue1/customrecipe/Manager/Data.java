package jp.msfblue1.customrecipe.Manager;

import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.io.File;

/**
 * Created by msfblue1 on 2017/12/22.
 */
public class Data {
    NBTTagCompound resultitemtags = new NBTTagCompound();
    ItemStack result = new ItemStack(Material.AIR);
    ItemStack[] recipes = new ItemStack[9];

    public Data(File savedata){
        FileConfiguration data = YamlConfiguration.loadConfiguration(savedata);

    }

    public Data(ItemStack result,ItemStack[] recipes){
        this.recipes = recipes;
        this.result = result;
        this.resultitemtags = CraftItemStack.asNMSCopy(result).getTag();
    }

    public void saveRecipe(){

    }
}
