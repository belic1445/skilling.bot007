import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

@ScriptManifest(name = "EliteSkillBot", author = "Nicholas", version = 1.0, description = "Advanced Bot for All Skills", category = Category.MISC)
public class MainScript extends AbstractScript {

    private Skill currentSkill;

    @Override
    public void onStart() {
        log("EliteSkillBot initialized. Please select a skill to train.");
        currentSkill = new Woodcutting(); // Default to Woodcutting
    }

    @Override
    public int onLoop() {
        return currentSkill.onLoop();
    }

    @Override
    public void onExit() {
        if (currentSkill != null) {
            currentSkill.onExit();
        }
    }

    interface Skill {
        void onStart();
        int onLoop();
        void onExit();
    }

    class Woodcutting implements Skill {
        @Override
        public void onStart() {
            log("Starting Woodcutting...");
        }

        @Override
        public int onLoop() {
            log("Chopping trees...");
            return 1000;
        }

        @Override
        public void onExit() {
            log("Woodcutting finished.");
        }
    }

    class Fishing implements Skill {
        @Override
        public void onStart() {
            log("Starting Fishing...");
        }

        @Override
        public int onLoop() {
            log("Catching fish...");
            return 1000;
        }

        @Override
        public void onExit() {
            log("Fishing finished.");
        }
    }

    class Mining implements Skill {
        @Override
        public void onStart() {
            log("Starting Mining...");
        }

        @Override
        public int onLoop() {
            log("Mining ores...");
            return 1000;
        }

        @Override
        public void onExit() {
            log("Mining finished.");
        }
    }

    class Combat implements Skill {
        @Override
        public void onStart() {
            log("Starting Combat...");
        }

        @Override
        public int onLoop() {
            log("Fighting NPCs...");
            return 1000;
        }

        @Override
        public void onExit() {
            log("Combat finished.");
        }
    }
}

