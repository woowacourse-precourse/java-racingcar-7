package racingcar.io;

public class OutputView {

    public void printResult(String result) {
        System.out.println(result + "\n");
    }

    public void printWinners(String winnerMessage) {
        System.out.println("최종 우승자 : " + winnerMessage);
    }

    public void printRequestInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRequestInputNumberOfTimesMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
}
