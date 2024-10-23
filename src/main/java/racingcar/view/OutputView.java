package racingcar.view;

public class OutputView {

    public void printExecutionResult() {
        System.out.println("실행 결과");
    }

    public void printRacingResult(String name, int score) {
        System.out.println(name + " : " + "-".repeat(score));
    }

    public void printWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
