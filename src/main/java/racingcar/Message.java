package racingcar;

public enum Message {

    RACING_CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ILLEGAL_NAME_LENGTH("[ERROR] 이름의 길이는 1부터 5까지만 가능합니다."),
    TRY_COUNT("시도할 횟수는 몇 회인가요?"),
    TRY_COUNT_NUMBER_ONLY("[ERROR] 시도 횟수는 숫자여야 합니다."),
    RESULT("\n실행 결과"),
    WINNER("최종 우승자 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
