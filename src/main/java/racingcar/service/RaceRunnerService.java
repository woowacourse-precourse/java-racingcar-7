package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RaceHistory;

public class RaceRunnerService {

    private final HistoryService historyService;

    public RaceRunnerService() {
        this.historyService = new HistoryService();
    }

    public RaceHistory runRaces(List<Car> cars, int count) {
        for (int i = 0; i < count; i++) {
            moveCars(cars);
            historyService.recordRound(cars);
        }
        return historyService.getHistory();
    }

    private void moveCars(List<Car> cars) {
        cars.forEach(car -> {
            if (shouldMove()) {
                car.addResult();
            }
        });
    }

    private boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
