package racingcar.model;

import racingcar.model.dependency.validator.RacingCarValidator;

import java.util.Objects;

public class RacingCar {

    public final int DEFAULT_POSITION = 0;
    public final int DEFAULT_MOVE_DISTANCE = 1;
    public final int MIN_MOVEABLE_NUMBER = 4;

    private final RacingCarValidator racingCarValidator;
    private final String name;
    private int position;

    public RacingCar(String name, RacingCarValidator racingCarValidator) {
        racingCarValidator.validate(name);
        this.racingCarValidator = racingCarValidator;
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public RacingCar(RacingCar other) {
        this(other.name, other.racingCarValidator);
        this.position = other.position;
    }

    public void move(int randomValue) {
        if (isMoveable(randomValue)) {
            position += DEFAULT_MOVE_DISTANCE;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private boolean isMoveable(int condition) {
        return condition >= MIN_MOVEABLE_NUMBER;
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
