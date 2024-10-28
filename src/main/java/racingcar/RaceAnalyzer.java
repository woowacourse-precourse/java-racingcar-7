package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RaceAnalyzer {
    public List<String> findWinners(List<CarRecord> carRecords, Integer lastRound) {
        List<String> winners = new ArrayList<>();
        Integer maxDistance = 0;
        for (CarRecord carRecord : carRecords) {
            Integer lastMoveDistance = carRecord.getMoveCount(lastRound);
            if (lastMoveDistance > maxDistance) {
                maxDistance = lastMoveDistance;
            }
        }
        for (CarRecord carRecord : carRecords) {
            Integer lastMoveDistance = carRecord.getMoveCount(lastRound);
            if (Objects.equals(lastMoveDistance, maxDistance)) {
                winners.add(carRecord.getCarName());
            }
        }
        return winners;
    }
}
