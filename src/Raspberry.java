import javax.swing.*;
import java.awt.*;

public class Raspberry {

    public Raspberry (){
        Rasp R = new Rasp();
    }
    public static void draw (Graphics g){
        ImageIcon rasp = new ImageIcon("img/raspberry.png");
        g.drawImage(rasp.getImage(), 10,0,null);
    }
    private static class Rasp extends JComponent{
        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g); // отвечает заотрисовку панели
            draw(g);
        }
    }
}
