package racingcar;

import java.util.List;

public class RaceResultPrinter {

    public static void printRoundResult(List<String> carNames, List<Integer> positions) {
        for (int i = 0; i < carNames.size(); i++) {
            StringBuilder progress = new StringBuilder(carNames.get(i) + " : ");
            for (int j = 0; j < positions.get(i); j++) {
                progress.append("-");
            }
            System.out.println(progress);
        }
        System.out.println(); // 라운드 간 개행을 위한.
    }
}
