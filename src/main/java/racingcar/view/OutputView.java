package racingcar.view;

public class OutputView {

    private static final String RESULT = "실행결과";
    private static final String WINNER = "최종 우승자 : ";

    public void showResult() {
        printMessage(RESULT);
    }

    public void printRaceResult(String name, String position) {
        printMessage(name + " : " + position);
    }

    public void printWinner(String winner) {
        printMessage(WINNER + winner);
    }

    public void printRound(int round) {
        printMessage("<Round " + round + ">");
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
