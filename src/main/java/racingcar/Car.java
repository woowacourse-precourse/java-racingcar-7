package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        ExceptionHandler.validateCarNameLength(name);

        this.name = name;
    }

    public void moveCar() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
