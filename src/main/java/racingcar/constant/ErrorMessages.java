package racingcar.constant;

import static racingcar.constant.DomainConstants.MIN_CAR_COUNT;

public class ErrorMessages {
    public static String NAME_LENGTH_ERROR_MESSAGE = "이름은 1자 이상 5자 이하여야 합니다.";
    public static String CAR_NAME_DUPLICATE_ERROR_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    public static String CAR_COUNT_ERROR_MESSAGE = String.format("자동차는 최소 %d대 이상이어야 합니다.", MIN_CAR_COUNT);
    public static String TRIAL_COUNT_ERROR_MESSAGE = "시도 횟수는 양의 정수이어야 합니다.";
}
