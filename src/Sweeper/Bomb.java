package Sweeper;

/**
 * Created by maxim on 17.04.2021.
 */
class Bomb {

    private int totalBombs;
    private Matrix bombMap;

    Bomb(int totalBombs){
        this.totalBombs = totalBombs;
        fixBombCount();
    }

    void start(){
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }

    }

    private void placeBomb(){
        while (true){
            Coord coord = Ranges.getRandomCoord();
            if(Box.BOMB == bombMap.get(coord))
                continue;
            bombMap.set(coord, Box.BOMB);
            incNumbersAroundBomb(coord);
            break;
        }
    }

    Box get(Coord coord){
        return bombMap.get(coord);
    }

    private void fixBombCount(){
        int maxBombs = Ranges.getSize().x + Ranges.getSize().y / 2;
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