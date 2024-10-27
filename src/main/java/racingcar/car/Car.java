package racingcar.car;

import java.util.Objects;

public class Car {
    private static final int MOVING_CRITERION = 4;

    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void tryMoveForward(int value, int positionDelta) {
        if (canMove(value)) {
            position += positionDelta;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    private boolean canMove(int value) {
        return value >= MOVING_CRITERION;
    }

}
