package racingcar;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    public void moveForward() {
        this.position++;
    }

    public boolean isPositionSameAs(int value) {
        return this.position == value;
    }

    public String convertCurrentStateToString() {
        return name + " : " + "-".repeat(position);
    }

    public int compareMax(int position) {
        return Math.max(this.position, position);
    }


    @Override
    public String toString() {
        return this.name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
