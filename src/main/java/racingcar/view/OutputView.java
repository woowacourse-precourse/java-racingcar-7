package racingcar.view;

import java.util.List;

public class OutputView {
    public static void promptCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void promptTrialCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void displayResultHeader() {
        System.out.println("실행 결과");
    }

    public static void displayRoundResult(List<String> carNames, List<Integer> carPositions) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            System.out.println("-".repeat(carPositions.get(i)));
        }
        System.out.println();
    }

    public static void displayWinners(List<String> winnerNames) {
        String winnerNamesStr = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + winnerNamesStr);
    }
}
