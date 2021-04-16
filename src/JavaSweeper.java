import javax.swing.*;
import Sweeper.Box;
import Sweeper.Coord;
import Sweeper.Game;
import Sweeper.Ranges;

import java.awt.*;

/**
 * Created by maxim on 02.04.2021.
 */
public class JavaSweeper extends JFrame {
    private Game game;
    private JPanel panel;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args)
    {
        new JavaSweeper();
    }
    private JavaSweeper()
    {
        game = new Game(COLS, ROWS);
        Ranges.setSize(new Coord(COLS, ROWS));
        setImage();
        initJPanel();
        initJFrame();
    }
    private void initJFrame(){
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Закрытие фрейма
        setTitle("Сапёр");
        setLocationRelativeTo(null); //Окно по центру
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
    }
    private void initJPanel(){
        panel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord: Ranges.getAllCoords()) {
                    g.drawImage((Image) game.getBox(coord).image, coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE,  this);
                }
            }
        };
        panel.setPreferredSize(new Dimension
                (Ranges.getSize().x * IMAGE_SIZE,Ranges.getSize().y * IMAGE_SIZE));
        add(panel);
    }
    private void setImage(){
        for (Box box: Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }
    private Image getImage(String name)
    {
        String filename = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }


}