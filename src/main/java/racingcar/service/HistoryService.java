package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RaceHistory;
import racingcar.domain.RaceRound;

public class HistoryService {

    private final RaceHistory history;

    public HistoryService() {
        this.history = new RaceHistory();
    }

    public void recordRound(List<Car> cars) {
        RaceRound round = new RaceRound(cars);
        history.addRound(round);
    }

    public RaceHistory getHistory() {
        return history;
    }

}
