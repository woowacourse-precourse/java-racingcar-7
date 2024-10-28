package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    public static void winners(Racers racers) {
        List<String> winners = new ArrayList<>();
        int first = Integer.MIN_VALUE;

        for (Racer racer : racers) {
            first = Math.max(first, racer.getCurrentPlace());
        }

        for (Racer racer : racers) {
            if (racer.getCurrentPlace() == first) {
                winners.add(racer.getRacerName());
            }
        }
        View.outputWinners(winners);
    }
}
