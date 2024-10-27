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

    public void race() {
        for (long round = 1; round <= attemptNumber; round++) {
            attemptMove();
            recordResults(round);
        }
    }

    private void attemptMove() {
        carList.forEach(Car::tryMove);
    }

    private void recordResults(long round) {
        List<Record> recordList = new ArrayList<>();
        carList.forEach(car -> recordList.add(new Record(car)));

        result.put(round, recordList);
    }
}
