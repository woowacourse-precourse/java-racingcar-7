package racingcar.message;

public enum Message {

    // 입력 메시지
    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ATTEMPT_COUNT("시도할 횟수는 몇 회인가요?"),

    // 출력 메시지
    OUTPUT_ATTEMPT_RESULT("실행 결과"),
    OUTPUT_WINNER("최종 우승자 : "),

    // 에러 메시지
    ERROR_INVALID_CAR_NAME("자동차 이름 형식이 잘못되었습니다."),
    ERROR_DUPLICATE_CAR_NAME("이미 존재하는 자동차 이름입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
