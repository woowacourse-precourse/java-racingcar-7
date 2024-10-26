package racingcar.view;

import java.util.List;

public class OutputView {
    public static void outputRaceStartLine() {
        System.out.println("\n실행 결과");
    }

    public static void outputRaceFinalResult(List<String> winnerNames) {
        System.out.println(String.format("최종 우승자 : %s"
                , String.join(", ", winnerNames)));
    }
}
