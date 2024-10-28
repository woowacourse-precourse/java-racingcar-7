package racingcar.domain;

public class Car {

    private final String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(name, 0);
    }

    public void move(int number) {
        if (number >= 4) {
            increasePosition();
        }
    }

    public void increasePosition() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
