package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Winners {
    public static List<String> winner(Map<String, Integer> cars) {
        List<String> winners = new ArrayList<>();
        int first = Collections.max(cars.values());

        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            if (car.getValue() == first) {
                winners.add(car.getKey());
            }
        }
        return winners;
    }

    public static String printWinners(List<String> winners) {
        return String.join(", ", winners);
    }
}
