package ai.bot;

import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.methods.walking.Walking;
import org.dreambot.api.methods.input.Mouse;

public class MainAI extends AbstractScript {

    private static final int LOW_HEALTH_THRESHOLD = 30;

    @Override
    public int onLoop() {
        eatIfNeeded();
        fightMonsters();
        navigate();
        return 600;
    }

    // Method to eat if health is below threshold
    private void eatIfNeeded() {
        if (Skills.getCurrentHealth() < LOW_HEALTH_THRESHOLD) {
            Item food = getBestFood();
            if (food != null) {
                food.interact("Eat");
                sleep(1000); // Wait after eating
            }
        }
    }

    // Method to get the best food item from inventory
    private Item getBestFood() {
        for (Food food : Food.values()) {
            Item item = Inventory.getItem(food.name());
            if (item != null) {
                return item;
            }
        }
        return null;
    }

    // Fight monsters and attack them
    private void fightMonsters() {
        NPC monster = getClosestMonster();
        if (monster != null && monster.isAttackable()) {
            monster.interact("Attack");
        }
    }

    // Find the closest monster to attack
    private NPC getClosestMonster() {
        return getNpcs().closest(n -> n != null && n.isAttackable());
    }

    // Method to navigate the map
    private void navigate() {
        if (!getWalking().isRunning()) {
            getWalking().setRun(true);
        }
        Walking.walk(new Position(3200, 3200));
    }

    // Enum for food items
    private enum Food {
        SHRIMPS, COOKED_CHICKEN, COOKED_MEAT, BREAD
    }
}
