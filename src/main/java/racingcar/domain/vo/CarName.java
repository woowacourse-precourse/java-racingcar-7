package racingcar.domain.vo;

import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

public record CarName(String name) {

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
        return isLengthUnder5(name) || isBlank(name);
    }

    private boolean isBlank(final String name) {
        return name.isBlank();
    }

    private boolean isLengthUnder5(final String name) {
        return name.length() > 5;
    }
}
