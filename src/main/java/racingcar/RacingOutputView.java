package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RacingOutputView {
    public void printRoundResult(Round round) {
        System.out.println("실행 결과");
        Map<Car, Integer> roundResult = round.getRoundResult();

        for (int i = 0; i < round.getMoveCount(); i++) {
            for (Car car : roundResult.keySet()) {
                int movedCount = roundResult.get(car);
                System.out.println(car.getName() + " : " + "-".repeat(movedCount));
            }
        }
    }

    public void finalWinners(Round round) {
        Map<Car, Integer> roundResult = round.getRoundResult();
        Integer maxMovedCount = Collections.max(roundResult.values());

        List<String> winners = new ArrayList<>();
        for (Car car : roundResult.keySet()) {
            if (roundResult.get(car).equals(maxMovedCount)) {
                winners.add(car.getName());
            }
        }

        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
