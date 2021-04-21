package Sweeper;

/**
 * Created by maxim on 18.04.2021.
 */
class Flag {
    private Matrix flagMap;

    void start(){
        flagMap = new Matrix(Box.CLOSED);
        for (Coord coord: Ranges.getCoordsAround(new Coord(4,4))) {
            flagMap.set(coord, Box.OPENED);
        }
    }

    Box get(Coord coord){
        return flagMap.get(coord);
    }
}
