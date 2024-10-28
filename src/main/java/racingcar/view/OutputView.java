package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printRaceStartNotice() {
        System.out.println("\n실행 결과");
    }

    public static void printProgress(List<String> CarProgressVisualizations) {
        for (String processVisualization : CarProgressVisualizations) {
            System.out.println(processVisualization);
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
    
}
