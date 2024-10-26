package racingcar.game;

import racingcar.strategy.Condition;

public class Car {
    private static final String DASH = "-";

    private final String name;
    private final Condition condition;
    private int position;

    private Car(String name, Condition condition) {
        this.name = name;
        this.condition = condition;
    }
    public static Car generateCars(String carName, Condition condition) {
        return new Car(carName, condition);
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
