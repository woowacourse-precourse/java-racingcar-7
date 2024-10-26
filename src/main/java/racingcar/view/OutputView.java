package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<String> roundResult) {
        System.out.println();
        roundResult.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinningCars(List<String> winningCars) {
        System.out.println("최종 우승자 : " + winningCars.toString());
        //TODO: 최종 결과 구현
    }
}
