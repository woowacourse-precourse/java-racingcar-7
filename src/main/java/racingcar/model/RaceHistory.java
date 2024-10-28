package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceHistory {

    private final List<RoundHistory> raceHistory = new ArrayList<>();

    public void recordRoundResult(Cars cars) {
        RoundHistory roundHistory = new RoundHistory();
        cars.getCars().forEach(car -> roundHistory.write(new CarState(car)));
        raceHistory.add(roundHistory);
    }

    public List<RoundHistory> getRaceHistory() {
        return raceHistory;
    }
}