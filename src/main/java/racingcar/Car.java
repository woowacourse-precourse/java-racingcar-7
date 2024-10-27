package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return name + " : " + "-".repeat(position);
    }

    public void moveIfPossible(int randomNumber) {
        if (randomNumber >= 4) {
            position += 1;
        }
    }

}
