package racingcar.model;

import java.util.List;
import java.util.Objects;
import racingcar.model.dto.CarStatusDto;
import racingcar.util.randomnumber.RandomNumberStrategy;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int MAX_CAR_NAME_SIZE = 5;
    private static final int ONE_MOVE = 1;

    private final String name;
    private int position;
    private final RandomNumberStrategy randomNumberStrategy;

    private Car(String name, RandomNumberStrategy randomNumberStrategy) {
        validateCar(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
        this.randomNumberStrategy = randomNumberStrategy;
    }

    public static Car from(String name, RandomNumberStrategy randomNumberStrategy) {
        return new Car(name, randomNumberStrategy);
    }

    public void isMove() {
        int randomNumber = createRandomNumber();
        if (isRandomNumberSize(randomNumber)) {
            moveForward();
        }
    }

    public CarStatusDto mapStatusToDto() {
        return CarStatusDto.of(this.name, this.position);
    }

    public void addWinner(List<String> winners) {
        winners.add(this.name);
    }

    public int getMaxPosition(int maxPosition) {
        return Math.max(maxPosition, this.position);
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateCar(String name) {
        if (name.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private int createRandomNumber() {
        return randomNumberStrategy.generateNumber();
    }

    private boolean isRandomNumberSize(int randomNumber) {
        return randomNumber >= 4;
    }

    private void moveForward() {
        this.position += ONE_MOVE;
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
        return getPosition() == car.getPosition() && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
