package racingcar.util;

public enum Constants {
    GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,), 기준으로 구분)"),
    GAME_COUNT("시도할 회수는 몇 회인가요?"),
    GAME_RESULT("\n실행 결과"),
    GAME_END("최종 우승자 : "),
    NULL_INPUT("입력 값이 NULL 입니다."),
    CAR_NAME_DUPLICATE_ERROR("자동차 목록은 중복이 없어야 합니다."),
    CAR_NAME_WRONG_ERROR("자동차 목록은 쉼표로 구분된 비어있지 않은 문자여야 합니다."),
    CAR_NAME_SIZE_ERROR("자동차 목록은 1자 ~ 5자의 문자로 구성되어야 합니다."),
    CAR_NAME_EMPTY_ERROR("자동차 이름은 빈 문자열이 될 수 없습니다."),
    ROUND_NUM_WRONG_ERROR("시도 횟수는 1 이상의 숫자여야 한다."),
    ;

    private final String message;

    Constants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}