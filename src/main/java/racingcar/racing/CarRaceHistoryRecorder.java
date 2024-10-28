package racingcar.racing;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.persistence.CarRaceHistory;

public class CarRaceHistoryRecorder {

    private static final String LINE_BREAKER = "\n";

    private final CarRaceHistory carRaceHistory;

    public CarRaceHistoryRecorder(CarRaceHistory carRaceHistory) {
        this.carRaceHistory = carRaceHistory;
    }

    public void record(List<RacingCar> racingCars) {
        String result = getRaceProgress(racingCars);
        carRaceHistory.add(result);
    }

    private String getRaceProgress(List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(RacingCar::toString)
                .collect(Collectors.joining(LINE_BREAKER));
    }
}
