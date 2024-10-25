package racingcar.view;

public class OutputView {

    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE_HEADER = "실행 결과";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";

    public void printCarInputMessage() {
        System.out.println(CAR_INPUT_MESSAGE);
    }

    public void printCountInputMessage() {
        System.out.println(COUNT_INPUT_MESSAGE);
    }

    public void printResultHeader() {
        System.out.println(RESULT_MESSAGE_HEADER);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWinners(String message) {
        System.out.println(WINNER_MESSAGE_PREFIX + message);
    }
}
