package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RaceView {
    public static void displayCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void displayAttemptCountMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void displayProgress(Map<String, Integer> allProgress) {
        for (Map.Entry<String, Integer> entry : allProgress.entrySet()) {
            String name = entry.getKey();
            int value = entry.getValue();

            System.out.println(name + " : " + "-".repeat(value));
        }
    }

    public static void displayWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
