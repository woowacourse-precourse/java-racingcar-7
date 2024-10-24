package racingcar.view;

public class OutputView {

    private static final String carInputMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String countInputMessage = "시도할 횟수는 몇 회인가요?";
    private static final String resultMessage = "실행 결과";
    private static final String winnerMessage = "최종 우승자 : ";

    public void printCarInputMessage() {
        System.out.println(carInputMessage);
    }

    public void printCountInputMessage() {
        System.out.println(countInputMessage);
    }

    public void printResultMessage() {
        System.out.println(resultMessage);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWinners(String message) {
        System.out.println(winnerMessage + message);
    }
}
