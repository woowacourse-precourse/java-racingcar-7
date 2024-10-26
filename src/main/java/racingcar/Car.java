package racingcar;

public class Car {
    private final String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            location++;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
