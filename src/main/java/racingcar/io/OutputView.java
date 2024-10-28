package racingcar.io;

public class OutputView {

    public void printResult(String result) {
        System.out.println(result + "\n");
    }

    public void printWinners(String winnerMessage) {
        System.out.println("최종 우승자 : " + winnerMessage);
    }
}
