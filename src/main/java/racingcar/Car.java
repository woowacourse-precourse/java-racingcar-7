package racingcar;

public class Car {

    private final String name;

    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int input) {
        if (input < 4){
            return;
        }

        distance++;
    }

    public int getDistance() {
        return distance++;
    }

    public String getName() {
        return name;
    }
}
