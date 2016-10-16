package chatcondes;

import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CHAT2 {

    public static void main(String[] args) throws IOException {
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }

        chatcondes.cChat Chat = new chatcondes.cChat();
        Chat.verVentanaChat();

    }

}
