package racingcar.view;

import java.util.List;

public class OutputView {

    public static void displayRaceResult(List<String> carNames, List<Integer> carPositions) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            printProgress(carPositions.get(i));
        }
        System.out.println();
    }

    public static void displayWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static void printProgress(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
