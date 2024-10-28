package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RoundHistory {

    private final List<CarState> roundHistory = new ArrayList<>();

    public void write(CarState carState) {
        roundHistory.add(carState);
    }

    public List<CarState> getRoundHistory() {
        return roundHistory;
    }
}