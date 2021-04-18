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
        incNumbersAroundBomb(coord);
    }
    Box get(Coord coord){
        return bombMap.get(coord);
    }

    public int getTotalBombs() {
        return totalBombs;
    }

    private void incNumbersAroundBomb(Coord coord){
        for (Coord around: Ranges.getCoordsAround(coord)) {
            if(Box.BOMB != bombMap.get(around)){
                bombMap.set(around, bombMap.get(around).getNextNumberBox());
            }
        }
    }


}