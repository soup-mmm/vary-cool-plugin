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

        Location spawn = player.getBedSpawnLocation();

        if (spawn == null) {
            org.bukkit.World overworld = Bukkit.getWorlds().get(0);
            player.teleport(new Location(overworld, 0, 64, 0));
            return true;
        }

        player.sendMessage(player.getName() + " is home");
        player.teleport(spawn);

        return true;
    }
}
