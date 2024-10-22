package racingcar.view;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputAttemptCountMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printExecutionResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printEachStepResult(List<String> carNames, List<Integer> moveCounts, int totalCarCounts) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < totalCarCounts; i++) {
            result.append(carNames.get(i)).append(" : ").append("-".repeat(moveCounts.get(i))).append('\n');
        }
        System.out.println(result);
    }

    public static void printSoloWinnerMessage(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
