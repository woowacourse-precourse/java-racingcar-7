package racingcar.domain.vo;

import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

public class CarName {

    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name.trim();
    }

    private void validateName(String name) {
        if (isUsableName(name)) {
            throw new BusinessException(RacingCarExceptionMessage.NAME_LENGTH_OUT_OF_RANGE);
        }
    }

    private boolean isUsableName(String name) {
        return name.trim().length() > 5 || name.trim().isEmpty();
    }

    public String getName() {
        return name;
    }
}
