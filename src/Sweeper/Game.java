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
        openBox(coord);
        checkWinner();
    }

    private void checkWinner(){
        if(state == GameState.PLAYED)
            if(flag.getCountOfClosedBoxes() == bomb.getTotalBombs())
                state = GameState.WINNER;

    }

    private void openBox(Coord coord){
        switch (flag.get(coord)){
            case OPENED:return;
            case FLAGED:return;
            case CLOSED:
                switch (bomb.get(coord)){
                    case ZERO:openBoxesAround(coord);return;
                    case BOMB:openBombs(coord);return;
                    default:
                        flag.setOpenedBox(coord);
                        return;
                }
        }
    }

    private void openBombs(Coord bombed) {
        state = GameState.BOMBED;
        flag.setBombedToBox(bombed);
        for (Coord coord: Ranges.getAllCoords()) {
            if(bomb.get(coord) == Box.BOMB)
                flag.setOpenedToClosedBomb(coord);
            else
                flag.setNoBombToFlagedSafeBox(coord);
        }
    }

    private void openBoxesAround(Coord coord) {
        flag.setOpenedBox(coord);
        for (Coord around: Ranges.getCoordsAround(coord)) {
            openBox(around);
        }
    }

    public void pressRightButton(Coord coord) {
        flag.toogleFlagedToBox(coord);
    }

    public GameState getState() {
        return state;
    }
}
