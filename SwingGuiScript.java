DreamBotScripts/
  ├── src/
      ├── SwingGuiScript.java
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.methods.input.Keyboard;
import org.dreambot.api.methods.input.Mouse;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.utilities.Timer;
import org.dreambot.api.methods.tabs.Tab;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@ScriptManifest(name = "Swing GUI Script", author = "YourName", version = 1.0)
public class SwingGuiScript extends AbstractScript {

    private JFrame frame;
    private JButton startButton;
    private JTextField textField;
    
    @Override
    public void onStart() {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Swing GUI Example");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            textField = new JTextField("Hello, DreamBot!");
            textField.setBounds(50, 50, 200, 30);

            startButton = new JButton("Start");
            startButton.setBounds(50, 100, 200, 30);
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Action when the button is pressed
                    log("Start button pressed!");
                }
            });

            frame.setLayout(null);
            frame.add(textField);
            frame.add(startButton);
            frame.setVisible(true);
        });
    }

    @Override
    public int onLoop() {
        // Your loop code here, for example:
        if (Inventory.contains("Item")) {
            log("Item found in inventory");
        }
        return 500;  // Adjust the sleep time for the script's loop
    }

    @Override
    public void onExit() {
        log("Script has exited.");
    }
}
