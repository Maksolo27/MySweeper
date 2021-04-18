package Sweeper;

/**
 * Created by maxim on 17.04.2021.
 */
class Bomb {

    private int totalBombs;
    private Matrix bombMap;

    Bomb(int totalBombs){
        this.totalBombs = totalBombs;
    }

    void start(){
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }

    }
    private void placeBomb(){
        Coord coord = Ranges.getRandomCoord();
        bombMap.set(coord, Box.BOMB);
        for (Coord around: Ranges.getCoordsAround(coord)) {
            bombMap.set(around, Box.NUM1);
        }
    }
    Box get(Coord coord){
        return bombMap.get(coord);
    }

    public int getTotalBombs() {
        return totalBombs;
    }


}