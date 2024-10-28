package racingcar.view;

public class OutputView {

    public void printCarInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResultHeader() {
        System.out.println("실행 결과");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWinners(String message) {
        System.out.println("최종 우승자 : " + message);
    }
}
