package Sweeper;

/**
 * Created by maxim on 16.04.2021.
 */
public class Game {

    private Bomb bomb;
    private Flag flag;
    private GameState state;

    public Game(int cols, int rows, int bombs){
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }

    public void start(){
        bomb.start();
        flag.start();
        state = GameState.PLAYED;
    }

    public Box getBox(Coord coord){
        if(flag.get(coord) == Box.OPENED)
            return bomb.get(coord);
        else
            return flag.get(coord);
    }

    public void pressLeftButton(Coord coord){
        flag.setOpenedBox(coord);
    }

    public void pressRightButton(Coord coord) {
        flag.toogleFlagedToBox(coord);
    }
}
