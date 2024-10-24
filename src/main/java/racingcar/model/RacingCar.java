package racingcar.model;

import racingcar.model.moving_strategy.MovingStrategy;

import java.util.Objects;

public class RacingCar {

    private final int DEFAULT_POSITION = 0;
    private final int MAX_NAME_LENGTH = 5;
    private final int DEFAULT_MOVE_DISTANCE = 1;

    private final String name;
    private final MovingStrategy movingStrategy;
    private int position;

    public RacingCar(String name, MovingStrategy movingStrategy) {
        validateName(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
        this.movingStrategy = movingStrategy;
    }

    public RacingCar(RacingCar other) {
        validateName(other.name);
        this.name = other.name;
        this.position = other.position;
        this.movingStrategy = other.movingStrategy;
    }

    public void moveRandomly() {
        if (movingStrategy.isMovable()) {
            position += DEFAULT_MOVE_DISTANCE;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
