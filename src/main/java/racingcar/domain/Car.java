package racingcar.domain;

public class Car {
    public String name;
    private final StringBuilder distance;

    public Car(String name) {
        this.name = name;
        distance = new StringBuilder();
    }

    public void move() {
        distance.append("-");
    }

    public String getCurrentDistance() {
        return name + " : " + distance.toString();
    }

    public int getFinalDistance() {
        if(distance.isEmpty()) {
            return 0;
        }
        return distance.length();
    }
}
