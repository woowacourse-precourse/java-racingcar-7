package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void move() {
        if(RandomNumberGenerator.generateRandomNumber() >= 4) {
            position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }
}
