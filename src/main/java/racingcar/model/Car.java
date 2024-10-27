package racingcar.model;

import java.util.List;
import java.util.Objects;
import racingcar.model.dto.CarStatusDto;
import racingcar.model.primitive.Name;
import racingcar.model.primitive.Position;
import racingcar.util.randomnumber.RandomNumberStrategy;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int MIN_MOVE_CONDITION = 4;

    private final Name name;
    private final Position position;
    private final RandomNumberStrategy randomNumberStrategy;

    private Car(String name, RandomNumberStrategy randomNumberStrategy) {
        this.name = Name.from(name);
        this.position = Position.from(DEFAULT_POSITION);
        this.randomNumberStrategy = randomNumberStrategy;
    }

    public static Car of(String name, RandomNumberStrategy randomNumberStrategy) {
        return new Car(name, randomNumberStrategy);
    }

    public void isMove() {
        int randomNumber = createRandomNumber();
        if (isMoveCondition(randomNumber)) {
            moveForward();
        }
    }

    public CarStatusDto mapStatusToDto() {
        return CarStatusDto.of(name.getName(), position.getPosition());
    }

    public void addWinner(List<String> winners) {
        name.add(winners);
    }

    public int findMaxPosition(int maxPosition) {
        return position.calculateMaxPosition(maxPosition);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position.isMax(maxPosition);
    }

    private int createRandomNumber() {
        return randomNumberStrategy.generateNumber();
    }

    private boolean isMoveCondition(int randomNumber) {
        return randomNumber >= MIN_MOVE_CONDITION;
    }

    private void moveForward() {
        position.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
