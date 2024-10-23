package racingcar.view;

public class OutputView {

    private final String INPUT_CAR_NAMES_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표() 기준으로 구분)";
    private final String INPUT_TRY_COUNT_MSG = "시도할 횟수는 몇 회인가요?";
    private final String RESULT_MSG = "실행 결과";

    public void printCarNameMessage() {
        System.out.println(INPUT_CAR_NAMES_MSG);
    }

    public void printTryCountMessage() {
        System.out.println(INPUT_TRY_COUNT_MSG);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MSG);
    }
}
