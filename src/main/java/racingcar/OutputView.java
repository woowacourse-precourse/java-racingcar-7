package racingcar;

import java.util.List;

public class OutputView {

    public static void displayResults(List<RoundResult> roundResults) {
        System.out.println();
        System.out.println("실행 결과");

        for (RoundResult roundResult : roundResults) {
            displayRoundResults(roundResult);
            System.out.println();
        }
    }

    private static void displayRoundResults(RoundResult roundResult) {
        List<String> carNames = roundResult.getCarNames();
        List<Integer> carPositions = roundResult.getCarPositions();

        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            int carPosition = carPositions.get(i);

            System.out.println(carName + " : " + "-".repeat(carPosition));
        }
    }

    public static void displayWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}