package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public final class Car {
    private static final int MOVE_CRITERIA = 4;
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String BLANK_NAME_ERROR = "자동차 이름은 공백일 수 없습니다.";
    private static final String NAME_LENGTH_ERROR = "자동차 이름은 %d자 이하만 가능합니다.".formatted(NAME_LENGTH_LIMIT);
    private final String name;
    private Integer position = 0;

    private void validateBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_NAME_ERROR);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    public Car(String name) {
        name = name.strip();
        validateBlankName(name);
        validateNameLength(name);
        this.name = name;
    }

    public void move() {
        int randomInteger = Randoms.pickNumberInRange(0, 9);
        if (randomInteger >= MOVE_CRITERIA) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Car) obj;
        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}