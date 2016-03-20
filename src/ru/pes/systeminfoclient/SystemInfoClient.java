package ru.pes.systeminfoclient;


import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.log4j.Logger;
import ru.pes.systeminfoclient.view.MainPanel;


public class SystemInfoClient {

    JFrame fr;
    MainPanel panel;
    private static final Logger logger = Logger.getLogger(SystemInfoClient.class);
    private SystemInfoClient() {
        logger.info("Start programm...");
        showMainFrame();
    }
        
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            logger.error("Can't set LaF...", ex);
        }
        new SystemInfoClient();
    }
    
    private void showMainFrame() {
        fr = new JFrame("Главное окно");
        fr.setLocationRelativeTo(null);
        panel = new MainPanel();
        fr.setSize(panel.getPreferredSize());
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        fr.getContentPane().add(panel);
    }
}
