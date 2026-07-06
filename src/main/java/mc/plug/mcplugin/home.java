package mc.plug.mcplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class home implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!(sender instanceof Player player)) {
            return false;
        }

        timers Timer = new timers();

        boolean isPvp = Timer.pvp;
        int timeLeft = Timer.pvptime;

        if (isPvp == true) {
            player.sendMessage("your are in pvp time left "+ timeLeft);
            return true;
        }

        Location spawn = player.getBedSpawnLocation();

        if (spawn == null) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tp " + player.getName() + " 0 64 0" );
            return true;
        }

        player.sendMessage(player.getName() + " is home");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp " + player.getName() + " " + spawn.getBlockX() + " " + spawn.getBlockY() + " " + spawn.getBlockZ());

        return true;
    }
}
