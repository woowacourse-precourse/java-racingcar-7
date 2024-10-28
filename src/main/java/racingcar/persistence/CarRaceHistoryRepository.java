package racingcar.persistence;

import java.util.ArrayList;
import java.util.List;

public class CarRaceHistoryRepository {

    private static final CarRaceHistoryRepository INSTANCE = new CarRaceHistoryRepository();
    private final List<String> histories = new ArrayList<>();

    private CarRaceHistoryRepository() {
    }

    public static CarRaceHistoryRepository getInstance() {
        return INSTANCE;
    }

    public void add(String result) {
        histories.add(result);
    }

    public List<String> getHistories() {
        return new ArrayList<>(histories);
    }
}
