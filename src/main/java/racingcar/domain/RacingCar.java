package racingcar.domain;

import static racingcar.constant.RacingConstant.RACING_CAR_NAME_MAX_LENGTH;
import static racingcar.constant.RacingConstant.RACING_CAR_MOVE_THRESHOLD;

public class RacingCar {

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        name = name.strip();

        validateCarName(name);

        this.name = name;
    }

    private void validateCarName(String name) {
        if (isCarNameBlank(name)) {
            throw new IllegalArgumentException("자동차 이름이 비어있습니다.");
        }

        if (isCarNameLengthExceeded(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하 여야 합니다.");
        }
    }

    public void move(int numberValue) {
        if (isStopByNumberValue(numberValue)) {
            return;
        }

        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private boolean isCarNameBlank(String name) {
        return name.isBlank();
    }

    private boolean isCarNameLengthExceeded(String name) {
        return name.length() > RACING_CAR_NAME_MAX_LENGTH;
    }

    private boolean isStopByNumberValue(int numberValue) {
        return numberValue < RACING_CAR_MOVE_THRESHOLD;
    }
}
