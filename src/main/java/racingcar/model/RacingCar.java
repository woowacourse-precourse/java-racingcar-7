package racingcar.model;

import racingcar.model.dependency.RacingCarDependency;

import java.util.Objects;

public class RacingCar {

    private final int DEFAULT_POSITION = 0;
    private final int DEFAULT_MOVE_DISTANCE = 1;
    private final int MIN_MOVEABLE_NUMBER = 4;

    private final String name;
    private final RacingCarDependency racingCarDependency;
    private int position;

    public RacingCar(String name, RacingCarDependency racingCarDependency) {
        this.racingCarDependency = racingCarDependency;
        this.racingCarDependency.racingCarValidator().validate(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public RacingCar(RacingCar other) {
        this(other.name, other.racingCarDependency);
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
