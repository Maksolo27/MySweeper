package Sweeper;

/**
 * Created by maxim on 16.04.2021.
 */
public class Game {



    public Game(int cols, int rows){
        Ranges.setSize(new Coord(cols, rows));
    }

    public Box getBox(Coord coord){
         return Box.values()[(coord.x + coord.y) % Box.values().length];
    }
}
