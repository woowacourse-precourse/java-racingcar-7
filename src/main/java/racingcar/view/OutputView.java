package racingcar.view;

import java.util.List;

public class OutputView {
    public static void title() {
        System.out.println("실행 결과");
    }

    public static void printProcess(List<String> carNameList, int[] results) {
        for (int i = 0; i < results.length; i++) {
            System.out.println(carNameList.get(i) + " : " + "-".repeat(results[i]));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.get(0));
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }
}
