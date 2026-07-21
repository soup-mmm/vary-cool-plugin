package mc.plug.mcplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class test123 implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length > 0) {

            if (args[0].equalsIgnoreCase("test")) {
                Bukkit.broadcastMessage("You triggered the test subcommand!");
                return true;
            }

            sender.sendMessage("Unknown subcommand. Use /lol test");
            return true;
        }

        sender.sendMessage("hi");

        return true;
    }
}
