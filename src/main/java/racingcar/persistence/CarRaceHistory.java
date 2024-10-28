package racingcar.persistence;

import java.util.ArrayList;
import java.util.List;

public class CarRaceHistory {

    private static final CarRaceHistory INSTANCE = new CarRaceHistory();
    private final List<String> histories = new ArrayList<>();

    private CarRaceHistory() {
    }

    public static CarRaceHistory getInstance() {
        return INSTANCE;
    }

    public void add(String result) {
        histories.add(result);
    }
}
