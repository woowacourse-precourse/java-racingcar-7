package racingcar.model;

import racingcar.model.moving_strategy.MovingStrategy;
import racingcar.model.validator.RacingCarValidator;

import java.util.Objects;

public class RacingCar {

    private final int DEFAULT_POSITION = 0;
    private final int DEFAULT_MOVE_DISTANCE = 1;

    private final String name;
    private final MovingStrategy movingStrategy;
    private final RacingCarValidator racingCarValidator;
    private int position;

    public RacingCar(String name, RacingCarValidator racingCarValidator, MovingStrategy movingStrategy) {
        racingCarValidator.validate(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
        this.movingStrategy = movingStrategy;
        this.racingCarValidator = racingCarValidator;
    }

    public RacingCar(RacingCar other) {
        this(other.name, other.racingCarValidator, other.movingStrategy);
        this.position = other.position;
    }

    public void move() {
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
