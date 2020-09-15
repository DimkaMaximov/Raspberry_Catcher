import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame {

    private static Image background;
    private static Image raspberry;
    private static float Rleft = 100;
    private static float Rup = -100;
    private static long Rtime;
    private static float Rplace = 100;


    public GameWindow onGame() throws IOException {

        background = ImageIO.read(GameWindow.class.getResourceAsStream("img/background.jpg"));
        raspberry = ImageIO.read(GameWindow.class.getResourceAsStream("img/raspberry.png"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300, 100);
        setSize(900, 600);
        setResizable(false);
        Rtime = System.nanoTime();
        GameField gameField = new GameField();
        add(gameField);
        setVisible(true);
        return null;
    }

        private static void OnRepaint (Graphics g){
            long current_time = System.nanoTime();
            float delta_time = (current_time - Rtime) * 0.000000001f;
            Rtime = current_time;
            Rup = Rup + Rplace * delta_time;
            g.drawImage(background, 0, 0, null);
            g.drawImage(raspberry, (int)Rleft, (int)Rup, null);
        }

        private class GameField extends JPanel {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // отвечает заотрисовку панели
                OnRepaint(g);
                repaint();
            }
        }
    }