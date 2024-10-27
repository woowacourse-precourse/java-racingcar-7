package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("Car name must be between 1 and 5!");
        }
        this.name = name;
    }

    private void move(int randomNumber) {
        if(randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
