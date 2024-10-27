package racingcar.game.model;

import static racingcar.game.constant.ExceptionMessage.CAR_NAME_IS_BLANK;
import static racingcar.game.constant.ExceptionMessage.INVALID_CAR_NAME_LENGTH;

public class Name {
    private static Integer MAX_CAR_NAME_COUNT = 5;
    private static Integer MIN_CAR_NAME_COUNT = 1;
    private String name;

    public Name(String name) {
        name = name.trim();
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_IS_BLANK.getMessage());
        }
        if (name.length() < MIN_CAR_NAME_COUNT || name.length() > MAX_CAR_NAME_COUNT) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
