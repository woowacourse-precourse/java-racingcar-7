package racingcar.message;

public enum SystemMessage implements MessageProvider {

    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_NUMBER_MESSAGE("시도할 횟수는 몇 회인가요?"),
    OUTPUT_RACING_RESULT_MESSAGE("실행 결과"),
    OUTPUT_WINNER_MESSAGE("최종 우승자 : "),
    ;

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
