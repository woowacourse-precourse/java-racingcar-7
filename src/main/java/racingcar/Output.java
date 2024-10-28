package racingcar;

public class Output {
    public void carInputComment() {
        final String CAR_INPUT_COMMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        print(CAR_INPUT_COMMENT);
    }

    public void tryCountComment() {
        final String Try_COUNT_COMMENT = "시도할 횟수는 몇 회인가요?";
        print(Try_COUNT_COMMENT);
    }

    public void executionResultComment() {
        final String EXECUTION_RESULT_COMMENT = "실행 결과";
        print(EXECUTION_RESULT_COMMENT);
    }

    public void resultByOrder(String result) {
        print(result);
    }

    private void print(String comment) {
        System.out.println(comment);
    }
}
