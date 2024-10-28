package racingcar.game;

import racingcar.strategy.Condition;

public class Car {
    private static final String DASH = "-";

    private final String name;
    private final Condition condition;
    private int position;

    private Car(String name) {
        this.name = name;
        this.condition = Condition.getCurrentCondition();
    }

    public static Car generateCars(String carName) {
        return new Car(carName);
    }

    public void move() {
        if (condition.canMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return getName() + " : " + DASH.repeat(position);
    }

}
