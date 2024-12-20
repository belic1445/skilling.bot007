package ai.bot;

import org.dreambot.api.wrappers.items.Item;
import java.util.HashSet;
import java.util.Set;

public class ItemLearning {

    private Set<String> knownItems = new HashSet<>();

    // Method to learn about an item
    public void learnItem(Item item) {
        if (item != null && !knownItems.contains(item.getName())) {
            knownItems.add(item.getName());
        }
    }

    // Get all known items
    public Set<String> getKnownItems() {
        return knownItems;
    }
}
