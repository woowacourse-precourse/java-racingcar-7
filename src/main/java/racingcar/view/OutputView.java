package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printGetCarsNameGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)");
    }

    public void printGetAttemptCountGuide() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResult(List<Map<String, Integer>> result) {
        for (Map<String, Integer> round : result) {
            printRoundResult(round);
            System.out.println();
        }
    }

    private void printRoundResult(Map<String, Integer> round) {
        for (Map.Entry<String, Integer> entry : round.entrySet()) {
            String name = entry.getKey();
            int state = entry.getValue();
            System.out.println(name + " : " + "-".repeat(state));
        }
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
