package ai.bot;

import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.methods.container.impl.Inventory;

public class Combat {

    // Method to equip the best weapon for combat
    public static void equipBestWeapon() {
        Item bestWeapon = getBestWeapon();
        if (bestWeapon != null) {
            bestWeapon.interact("Wield");
        }
    }

    // Method to get the best weapon from inventory
    private static Item getBestWeapon() {
        return Inventory.getItems(i -> i != null && i.getName().contains("sword")).first();
    }
}
