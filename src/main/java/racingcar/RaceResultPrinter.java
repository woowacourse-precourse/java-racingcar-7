package racingcar;

import java.util.List;

public class RaceResultPrinter {

    public static void printRoundResult(List<String> carNames, List<Integer> positions) {
        for (int i = 0; i < carNames.size(); i++) {
            printCarProgress(carNames.get(i), positions.get(i));
        }
        System.out.println(); // 라운드 간 개행
    }

    private static void printCarProgress(String carName, int position) {
        StringBuilder progress = new StringBuilder(carName + " : ");
        progress.append("-".repeat(Math.max(0, position))); // 위치에 따른 진행 표시
        System.out.println(progress);
    }
}

