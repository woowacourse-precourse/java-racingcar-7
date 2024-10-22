package racingcar.domain;

public class Car {

    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
    public void move(){
        this.distance ++;
    }

    public String getPosition(){
        return "-".repeat(distance);
    }
}
