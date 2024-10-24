package racingcar.model;

public class Distance {
    private final int distance;

    public Distance() {
        this.distance = 0;
    }
    public int getDistance(){
        return distance;
    }

    public int go(int value){
        return this.distance + value;
    }
}
