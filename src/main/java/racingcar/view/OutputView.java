package racingcar.view;

public class OutputView {

    public void printStartGame() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCurrentResult(String currentResult) {
        System.out.println(currentResult);
    }

    public void printWinner(String winner) {
        System.out.printf("최종 우승자 : %s%n", winner);
    }
}
