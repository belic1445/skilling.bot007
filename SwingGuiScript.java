import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.interactive.GameObject;
import javax.swing.*;
import java.awt.*;
import javax.swing.SwingUtilities;

@ScriptManifest(name = "Swing GUI Example", description = "An example script with improved GUI handling", author = "YourName", version = 1.0)
public class SwingGuiScript extends AbstractScript {

    private MyGUI gui;

    @Override
    public void onStart() {
        // Initialize GUI on the EDT to ensure thread safety
        SwingUtilities.invokeLater(() -> {
            gui = new MyGUI();
            gui.setVisible(true); // Make GUI visible on the EDT
        });
    }

    @Override
    public int onLoop() {
        // Example game logic goes here
        // Do not call Swing methods directly from this loop; keep game logic separate from GUI logic

        // If you need to update the GUI based on the game state, use invokeLater
        SwingUtilities.invokeLater(() -> {
            if (gui != null) {
                gui.updateStatus("Game is running");
            }
        });

        return 1000; // Sleep time between loops
    }

    @Override
    public void onExit() {
        // Optionally close the GUI when the script exits
        if (gui != null) {
            SwingUtilities.invokeLater(() -> gui.setVisible(false)); // Hide GUI safely
        }
    }

    // Custom GUI class
    public class MyGUI extends JFrame {
        private JLabel statusLabel;

        public MyGUI() {
            setTitle("Swing GUI Example");
            setSize(300, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());

            statusLabel = new JLabel("Waiting for game...");
            add(statusLabel);
        }

        // Update the status text safely on the EDT
        public void updateStatus(String status) {
            SwingUtilities.invokeLater(() -> statusLabel.setText(status));
        }
    }
}
