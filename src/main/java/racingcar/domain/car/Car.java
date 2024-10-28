package racingcar.domain.car;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }
}