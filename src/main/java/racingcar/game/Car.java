package racingcar.game;

import racingcar.strategy.MoveStrategy;

public class Car {
    private static final String DASH = "-";

    private final String name;
    private final MoveStrategy moveStrategy;
    private int position;

    private Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }
    public static Car generateCars(String carName, MoveStrategy moveStrategy) {
        return new Car(carName, moveStrategy);
    }

    public void move() {
        if (moveStrategy.canMove()) {
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
