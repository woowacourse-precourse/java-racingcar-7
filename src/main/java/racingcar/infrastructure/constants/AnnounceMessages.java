package racingcar.infrastructure.constants;

public enum AnnounceMessages {

    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_COUNT("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    WINNER("최종 우승자 : "),
    NEW_LINE("\n");

    private final String message;

    AnnounceMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
