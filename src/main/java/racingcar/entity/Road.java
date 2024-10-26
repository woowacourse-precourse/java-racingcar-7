package racingcar.entity;

public class Road {

    private int road;

    private Road (int road){
        this.road = road;
    }

    public int getRoad() {
        return road;
    }

    public void addRoad(int addLength){
        this.road+=addLength;
    }

}
