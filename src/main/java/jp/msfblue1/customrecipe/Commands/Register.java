package jp.msfblue1.customrecipe.Commands;

import jp.msfblue1.customrecipe.GUI.RegGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by msfblue1 on 2017/12/19.
 */
public class Register implements CommandExecutor{


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length > 0 && args[0].equalsIgnoreCase("reg")){
            if(sender instanceof Player){
                new RegGUI().openGUI((Player)sender);
            }
        }else{

        }
        return true;
    }
}
