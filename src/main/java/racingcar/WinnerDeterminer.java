package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerDeterminer {

    public static List<String> determineWinners(List<String> carNames, List<Integer> positions) {
        int maxDistance = positions.stream().max(Integer::compareTo).orElse(0);
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            if (positions.get(i) == maxDistance) {
                winners.add(carNames.get(i));
            }
        }
        return winners;
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
