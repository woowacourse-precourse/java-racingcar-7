package racingcar.view.enumerate;

public enum OutputConstant {
    RESULT_PRINT_SENTENCE("최종 우승자 : "),
    PRINT_INPUT_CAR_NAMES_SENTENCE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    PRINT_INPUT_TRY_TIMES_SENTENCE("시도할 횟수는 몇 회인가요?"),
    PRINT_RUNNING_RESULT_SENTENCE("실행 결과");
    private final String sentence;

    OutputConstant(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }
}