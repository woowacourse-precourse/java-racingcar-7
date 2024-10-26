package racingcar.car;

import static racingcar.car.ConditionChecker.canMove;

import java.util.Objects;

public class Car {
    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void tryMoveForward(int value, int positionDelta) {

        if (canMove(value)) {
            position += positionDelta;
        }
    }

    public String changeCurrentPositionalStatusToVisual(String symbol) {
        String positionalAppearance = symbol.repeat(position);
        return name + " : " + positionalAppearance;
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

}
