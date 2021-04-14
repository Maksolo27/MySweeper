import javax.swing.*;
import Sweeper.Box;
import java.awt.*;
import java.util.*;

/**
 * Created by maxim on 02.04.2021.
 */
public class JavaSweeper extends JFrame {
    private JPanel panel;
    private final int COLS = 15;
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args)
    {
        new JavaSweeper();
    }
    private JavaSweeper()
    {
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
                for (Box box: Box.values()) {
                    g.drawImage((Image) box.image, box.ordinal() * IMAGE_SIZE, 0, this);
                }
            }
        };
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE,ROWS * IMAGE_SIZE));
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