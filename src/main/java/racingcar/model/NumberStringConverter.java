package racingcar.model;

import racingcar.validator.MovingCountValidator;

public class NumberStringConverter {

    private final MovingCountValidator movingCountValidator = new MovingCountValidator();

    public Long convert(String rawMovingCount) {
        return movingCountValidator.validateAndParseMovingCount(rawMovingCount);
    }
}
