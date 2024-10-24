package racingcar.model;

import racingcar.util.ramdom.RandomRange;
import racingcar.util.ramdom.RandomUtils;

import java.util.Objects;

public class RacingCar {

    private final int DEFAULT_POSITION = 0;
    private final int MAX_NAME_LENGTH = 5;
    private final int DEFAULT_MOVE_DISTANCE = 1;
    private final int MIN_MOVEABLE_NUMBER = 4;

    private final String name;
    private int position;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public RacingCar(RacingCar other) {
        validateName(other.name);
        this.name = other.name;
        this.position = other.position;
    }

    public void moveRandomly(RandomRange randomRange) {
        int randomNumber = RandomUtils.generateRandomNumber(randomRange);
        if (isMoveable(randomNumber)) {
            move();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void move() {
        position += DEFAULT_MOVE_DISTANCE;
    }

    private boolean isMoveable(int number) {
        return number >= MIN_MOVEABLE_NUMBER;
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
