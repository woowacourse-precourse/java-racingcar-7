package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Racing {

    private final List<Car> carList;
    private final long attemptNumber;
    private final Map<Long, List<Record>> result = new HashMap<>();

    public Racing(List<Car> carList, long attemptNumber) {
        this.carList = carList;
        this.attemptNumber = attemptNumber;
    }

    public List<String> race() {
        for (long round = 1; round <= attemptNumber; round++) {
            attemptMove();
            recordResults(round);
        }

        return selectWinnerNames();
    }

    private void attemptMove() {
        carList.forEach(Car::tryMove);
    }

    private void recordResults(long round) {
        List<Record> recordList = new ArrayList<>();
        carList.forEach(car -> recordList.add(new Record(car)));

        result.put(round, recordList);
    }

    private List<String> selectWinnerNames() {
        long maxDistance = selectMaxDistance();
        List<Car> winners = carList.stream().filter(car -> car.getMoveCount() == maxDistance).toList();

        return winners.stream().map(Car::getName).toList();
    }

    private long selectMaxDistance() {
        List<Record> finalRecords = result.get(attemptNumber);
        long max = 0;
        for (Record record : finalRecords) {
            max = Math.max(max, record.getMoveCount());
        }

        return max;
    }
}
