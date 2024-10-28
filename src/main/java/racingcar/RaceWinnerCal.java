package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceWinnerCal {
    public String calculateWinners(List<String> carNames, List<Integer> carPositions) {

        int maxPosition = carPositions.stream().max(Integer::compareTo).orElse(0);
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            if (carPositions.get(i) == maxPosition) {
                winners.add(carNames.get(i));
            }
        }
        return String.join(", ", winners);
    }
}
