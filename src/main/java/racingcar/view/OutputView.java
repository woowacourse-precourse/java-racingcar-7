package racingcar.view;

import java.util.List;

public class OutputView {

    public void printRunResult() {
        System.out.println("\n" + "실행 결과");
    }

    public void printRoundResult(List<String> carStates) {
        carStates.forEach(System.out::println);
        System.out.println();
    }

    public void printWinnerPlayers(String players) {
        System.out.println("최종 우승자 : " + players);
    }
}
