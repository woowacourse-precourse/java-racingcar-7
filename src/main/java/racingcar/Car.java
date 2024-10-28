package racingcar;

public class Car {
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;


    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position += 1;
    }

    public String showPosition() {
        return "-".repeat(position);
    }

}
