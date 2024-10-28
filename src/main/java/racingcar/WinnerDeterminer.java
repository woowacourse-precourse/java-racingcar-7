package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerDeterminer {

    public static List<String> determineWinners(List<String> carNames, List<Integer> positions) {
        int maxDistance = getMaxDistance(positions);
        return findWinners(carNames, positions, maxDistance);
    }

    private static int getMaxDistance(List<Integer> positions) {
        return positions.stream().max(Integer::compareTo).orElse(0);
    }

    private static List<String> findWinners(List<String> carNames, List<Integer> positions, int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            addWinnerIfMaxDistance(carNames.get(i), positions.get(i), maxDistance, winners);
        }
        return winners;
    }

    private static void addWinnerIfMaxDistance(String carName, int position, int maxDistance, List<String> winners) {
        if (position == maxDistance) {
            winners.add(carName);
        }
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
