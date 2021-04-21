import javax.swing.*;
import Sweeper.Box;
import Sweeper.Coord;
import Sweeper.Game;
import Sweeper.Ranges;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by maxim on 02.04.2021.
 */
public class JavaSweeper extends JFrame {
    private Game game;
    private JPanel panel;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;
    private final int BOMBS = 10;

    public static void main(String[] args) {
        new JavaSweeper();
    }

    private JavaSweeper() {
        game = new Game(COLS, ROWS, BOMBS);
        game.start();
        Ranges.setSize(new Coord(COLS, ROWS));
        setImage();
        initJPanel();
        initJFrame();
    }
    private void initJFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Закрытие фрейма
        setTitle("Сапёр");
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
        pack();
        setLocationRelativeTo(null); //Окно по центру
    }

    private void initJPanel(){
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord: Ranges.getAllCoords()) {
                    g.drawImage((Image) game.getBox(coord).image, coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE,  this);
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                Coord coord = new Coord(x, y);
                if(e.getButton() == MouseEvent.BUTTON1)
                    game.pressLeftButton(coord);
                if(e.getButton() == MouseEvent.BUTTON3)
                    game.pressRightButton(coord);
                if(e.getButton() == MouseEvent.BUTTON2)
                    game.start();
                panel.repaint();//Перерисовка
            }
        });
        panel.setPreferredSize(new Dimension
                (Ranges.getSize().x * IMAGE_SIZE,Ranges.getSize().y * IMAGE_SIZE));
        add(panel);
    }

    private void setImage(){
        for (Box box: Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }

    private Image getImage(String name) {
        String filename = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }


}