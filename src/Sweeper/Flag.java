package Sweeper;

/**
 * Created by maxim on 18.04.2021.
 */
class Flag {
    private Matrix flagMap;

    void start(){
        flagMap = new Matrix(Box.CLOSED);
    }

    Box get(Coord coord){
        return flagMap.get(coord);
    }
}
