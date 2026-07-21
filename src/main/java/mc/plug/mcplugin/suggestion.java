package mc.plug.mcplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class suggestion implements TabCompleter {

    private final Map<String, List<String>> commandRegistry = Map.of(
        
        //"cool", List.of("soup") example if you type "/cool " is has the littel gray shugestions of like this
            
        //       soup
        // /cool 

    );

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (args.length == 1) {
            String currentInput = args[0].toLowerCase();

            List<String> activeSuggestions = commandRegistry.get(command.getName().toLowerCase());

            if (activeSuggestions == null) {
                return List.of();
            }

            return activeSuggestions.stream()
                    .filter(word -> word.toLowerCase().startsWith(currentInput))
                    .collect(Collectors.toList());
        }

        return List.of();
    }
}
