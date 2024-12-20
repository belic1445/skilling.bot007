package ai.bot;

import org.dreambot.api.methods.walking.Walking;
import org.dreambot.api.methods.map.Area;

public class Navigation {

    // Method to navigate to a specific area (e.g., a monster spawn area)
    public static void navigateToArea() {
        Area monsterArea = new Area(3200, 3200, 3250, 3250);
        if (!monsterArea.contains(getLocalPlayer())) {
            Walking.walk(monsterArea.getRandomTile());
        }
    }
}
