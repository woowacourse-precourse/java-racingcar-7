package racingcar.exception;

import racingcar.constants.GameConstatns;

public class ExceptionMessage {
    // 입력 형식 관련
    public static final String INVALID_NAME_FORMAT = "자동차 이름은 쉼표(,)로 구분하여 입력해야 합니다.";

    // 자동차 수 관련
    public static final String CAR_COUNT_UNDER = "자동차는 " + GameConstatns.CAR_COUNT_MIN + "대 이상이어야 합니다.";
    public static final String CAR_COUNT_OVER = "자동차는 " + GameConstatns.CAR_COUNT_MAX + "대 이하여야 합니다.";

    // 각 자동차 이름 관련
    public static final String DUPLICATE_NAME = "자동차 이름은 중복될 수 없습니다.";

    public static final String INVALID_NAME_CHARACTER = "자동차 이름은 한글, 영어, 숫자 중 하나를 포함해야 합니다.";
    public static final String NAME_LENGTH_UNDER = "자동차 이름은 " + GameConstatns.NAME_LENGTH_MIN + "자 이상이어야 합니다.";
    public static final String NAME_LENGTH_OVER = "자동차 이름은 " + GameConstatns.NAME_LENGTH_MAX + "자 이하여야 합니다.";


    public static final String ATTEMPT_COUNT = "시도 횟수는 " + GameConstatns.ATTEMPT_COUNT_MIN + "회 이상," +
             GameConstatns.ATTEMPT_COUNT_MAX + "회 이하이어야 합니다.";
    public static final String ATTEMPT_COUNT_UNDER = "시도 횟수는 " + GameConstatns.ATTEMPT_COUNT_MIN + "회 이상이어야 합니다.";
    public static final String ATTEMPT_COUNT_OVER = "시도 횟수는 " + GameConstatns.ATTEMPT_COUNT_MAX + "회 이하여야 합니다.";

}
