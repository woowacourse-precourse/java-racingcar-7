package racingcar;

public enum TextString {
    CAR_NAME_TEXT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    NAME_SEPARATOR(","),
    TRY_COUNT_TEXT("시도할 횟수는 몇 회인가요?"),
    RESULT_TEXT("실행 결과"),
    RACING_POSITION_TEXT("-"),
    NEW_LINE("\n");


    private final String text;

    TextString(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
