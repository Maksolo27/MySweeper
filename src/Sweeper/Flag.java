package Sweeper;

/**
 * Created by maxim on 18.04.2021.
 */
class Flag {
    private Matrix flagMap;
    private int countOfClosedBoxes;

    void start(){
        flagMap = new Matrix(Box.CLOSED);
        countOfClosedBoxes = Ranges.getSize().x * Ranges.getSize().y;
    }

    Box get(Coord coord){
        return flagMap.get(coord);
    }

    public void setOpenedBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
        countOfClosedBoxes--;
    }

    public void setFlagedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGED);
    }

    public void toogleFlagedToBox(Coord coord) {
        switch (flagMap.get(coord)){
            case FLAGED:
                setClosedToBox(coord);
                break;
            case CLOSED:
                setFlagedToBox(coord);
                break;
        }
    }

    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
    }

    public int getCountOfClosedBoxes() {
        return countOfClosedBoxes;
    }

    public void setBombedToBox(Coord coord) {
        flagMap.set(coord, Box.BOMBED);
    }

    void setOpenedToClosedBomb(Coord coord) {
        if(flagMap.get(coord) == Box.CLOSED)
            flagMap.set(coord, Box.CLOSED);

    }

    void setNoBombToFlagedSafeBox(Coord coord) {
        if(flagMap.get(coord) == Box.FLAGED)
            flagMap.set(coord, Box.NOBOMB);
    }


    int getCountOfFlagedBoxes(Coord coord) {
        int count = 0;
        for (Coord around: Ranges.getCoordsAround(coord)) {
            if(flagMap.get(around) == Box.FLAGED)
                count++;
        }
        return count;
    }
}
