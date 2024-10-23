package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final List<RacingCar> racingRecord;

    public Racing(List<String> carRacers) {
        this.racingRecord = changeStringToRacingCar(carRacers);
    }
    private ArrayList<RacingCar> changeStringToRacingCar(List<String> carRacers) {
        return carRacers.stream()
                .map(RacingCar::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void start(int totalTrialCount) {
        for (int i = 1; i <= totalTrialCount; i++) {
            racingRecord.forEach(RacingCar::moveOrStop);
        }
    }

    public List<RacingCar> getRacingRecord() {
        return racingRecord;
    }
}
