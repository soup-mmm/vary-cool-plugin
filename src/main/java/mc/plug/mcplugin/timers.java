package mc.plug.mcplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.HashMap;
import java.util.UUID;

public class timers implements Listener {

    // Stores <Player UUID, Seconds Left in Combat>
    public static HashMap<UUID, Integer> pvpTimers = new HashMap<>();

    public timers(JavaPlugin plugin) {
        // Start a background loop that runs every 1 second (20 ticks)
        new BukkitRunnable() {
            @Override
            public void run() {
                // Loop through a copy of the keys to avoid errors while modifying the map
                for (UUID uuid : new HashMap<>(pvpTimers).keySet()) {
                    int secondsLeft = pvpTimers.get(uuid) - 1;

                    if (secondsLeft <= 0) {
                        pvpTimers.remove(uuid); // Time is up! Remove them from combat
                        Player player = plugin.getServer().getPlayer(uuid);
                        if (player != null) {
                            player.sendMessage("You are no longer in combat.");
                        }
                    } else {
                        pvpTimers.put(uuid, secondsLeft); // Update the map with lowered time
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 20L);
    }

    @EventHandler
    public void updatePvpStatus(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            Player damager = (Player) event.getDamager();
            Player victim = (Player) event.getEntity();

            // Putting a UUID in a HashMap automatically overwrites old values.
            // This cleanly updates or resets their timer to 30 seconds.
            pvpTimers.put(damager.getUniqueId(), 30);
            pvpTimers.put(victim.getUniqueId(), 30);
        }
    }
}
