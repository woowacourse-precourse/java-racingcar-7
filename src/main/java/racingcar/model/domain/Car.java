package racingcar.model.domain;

public class Car {

    private static final int START_POSITION = 0;
    private static final int MINIMUM_MOVE = 4;

    private final String name;
    private final int position;


    private Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }


    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        if (name.length() >= 6 || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하여야 합니다.");
        }

        return new Car(name);
    }

    public int getPosition() {
        return this.position;
    }

    public Car moveForward(int number) {
        if (canMove(number)) {
            return new Car(this.name, this.position + number);
        }
        return this;
    }

    private boolean canMove(int number) {
        if (number < MINIMUM_MOVE) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.name;
    }
}
