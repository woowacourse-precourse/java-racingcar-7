package racingcar.domain.car;

import racingcar.strategy.MoveStrategy;

public class Car {
    private final String name;
    private int location;
    private final MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.location = 0;
        this.moveStrategy = moveStrategy;
    }

    public void moveIfPossible() {
        if (moveStrategy.shouldMove()) {
            location++;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public boolean isAtLocation(int maxLocation) {
        return location == maxLocation;
    }
}
