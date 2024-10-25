package racingcar.global.constant;

import racingcar.global.validator.InputValidator.ValidationMode;

public class InvalidInputExceptionMessage {
    public static final String INVALID_CAR_NAME_LENGTH_MESSAGE =
            String.format("자동차 이름은 %d자 이상 %d자 이하로 입력해 주세요.", ValidationMode.CAR_NAME.min, ValidationMode.CAR_NAME.max);

    public static final String EMPTY_CAR_NAME_MESSAGE =
            "자동차 이름을 입력해 주세요.";

    public static final String INVALID_CAR_COUNT_MESSAGE =
            String.format("자동차는 %d대 이상 %d 이하로 등록해 주세요.", ValidationMode.CAR_COUNT.min, ValidationMode.CAR_COUNT.max);

    public static final String INVALID_GAME_ROUND_MESSAGE =
            String.format("시도 횟수는 %d 이상 %d 이하의 자연수로 입력해 주세요.", ValidationMode.GAME_ROUND.min, ValidationMode.GAME_ROUND.max);
}
