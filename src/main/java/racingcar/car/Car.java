package racingcar.car;

import static racingcar.car.ConditionChecker.canMove;

import java.util.List;
import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    private Car(String name) {
        validateEmptyName(name);
        validateBlankName(name);
        validateLargeLengthName(name);

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

    public boolean isSamePosition(Car winnerCar) {
        return position == winnerCar.position;
    }

    public void provideNameIfWins(List<Car> winnerList, List<String> container) {
        if (winnerList.contains(this)) {
            container.add(name);
        }
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(position, o.position);
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

    private void validateEmptyName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비워둘 수 없습니다.");
        }
    }

    private void validateBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    private void validateLargeLengthName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
