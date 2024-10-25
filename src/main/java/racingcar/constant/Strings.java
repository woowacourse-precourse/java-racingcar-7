package racingcar.constant;

public enum Strings {
    // for racingCar
    REQUEST_RACING_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    MORE_THAN_ONE("한 대 이상의 자동차 이름이 필요합니다."),
    OVER_MAX_LENGTH("한 대 이상의 자동차 이름이 최대 길이를 초과했습니다."),
    EXIST_SAME_NAME("동일한 이름을 가진 자동차가 존재합니다."),

    // for record
    REQUEST_TRY_TIMES("시도할 횟수는 몇 회인가요?"),
    IS_NOT_NUMBER("시도 횟수 입력이 잘못 되었습니다."),
    PUT_OVER_ZERO("시도 횟수는 0회 이상이 입력 되어야 합니다."),
    ;

    private final String message;

    Strings(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
