package racingcar.domain.road.entity;

public class Road {

    private int length;

    public Road(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void addRoad(int addLength){
        this.length+=addLength;
    }

}
