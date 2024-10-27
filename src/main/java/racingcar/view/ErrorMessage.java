package racingcar.view;

import racingcar.constants.RacingGameConstants;

public enum ErrorMessage {
    NAME_TOO_LONG("자동차 이름은 5자를 초과할 수 없습니다."),
    EMPTY_CAR_NAMES("자동차 이름은 비어 있을 수 없으며, 쉼표(,)로 구분되어야 합니다."),
    DUPLICATE_NAME("자동차 이름은 중복될 수 없습니다."),
    MINIMUM_CARS("경주할 자동차는 최소 2대 이상이어야 합니다."),
    TRAILING_COMMA("자동차 이름 끝에 불필요한 쉼표가 포함될 수 없습니다."),
    EMPTY_NAME_IN_LIST("자동차 이름 목록에 빈 이름이 포함될 수 없습니다."),
    INVALID_TRY_COUNT("시도 횟수는 양의 정수여야 합니다."),
    EMPTY_TRY_COUNT("시도 횟수는 비어 있을 수 없습니다."),
    EXCEEDS_MAX_TRY_COUNT(
            "시도 횟수는 최대 " + RacingGameConstants.MAX_TRY_COUNT.getValue()
                    + "회 이하로 입력해 주세요."); // 최대 시도 횟수 제한 초과

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
