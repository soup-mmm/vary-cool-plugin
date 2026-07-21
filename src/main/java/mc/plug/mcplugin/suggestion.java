package mc.plug.mcplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class suggestion implements TabCompleter {

    // REGISTRY: Add a new command and its suggestions here in just ONE line.
    private final Map<String, List<String>> commandRegistry = Map.of(

            //"test", List.of("test") example

    );

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args.length == 1) {
            String currentInput = args[0].toLowerCase();

            // Grabs the correct list automatically based on the command typed
            List<String> activeSuggestions = commandRegistry.get(command.getName().toLowerCase());

            // If the command isn't in our registry above, do nothing
            if (activeSuggestions == null) {
                return List.of();
            }

            // Runs your exact filtering logic
            return activeSuggestions.stream()
                    .filter(word -> word.toLowerCase().startsWith(currentInput))
                    .collect(Collectors.toList());
        }

        return List.of();
    }
}
