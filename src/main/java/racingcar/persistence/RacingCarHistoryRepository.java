package racingcar.persistence;

import java.util.ArrayList;
import java.util.List;

public class RacingCarHistoryRepository {

    private static final RacingCarHistoryRepository INSTANCE = new RacingCarHistoryRepository();
    private final List<String> histories = new ArrayList<>();

    private RacingCarHistoryRepository() {
    }

    public static RacingCarHistoryRepository getInstance() {
        return INSTANCE;
    }

    public void add(String result) {
        histories.add(result);
    }

    public List<String> getHistories() {
        return new ArrayList<>(histories);
    }
}
