package racingcar.model.race;

import static racingcar.common.constant.SystemConstant.EMPTY_STRING;

public class Position {
    private String value;

    public static Position initiate() {
        return new Position();
    }

    private Position() {
        this.value = EMPTY_STRING;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
