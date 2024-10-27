package racingcar.util;

public enum ConstantVariable {
    FIRST_CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    MAX_TRY_COUNT("시도할 횟수는 몇 회인가요?"),
    PROGRAM_END_RESULT_START("실행 결과"),
    FINAL_WINNER("최종 우승자 : "),
    ;

    private final String value;

    ConstantVariable(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
