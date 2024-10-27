package racingcar.model;

import java.util.List;

public class RaceLog {
    private final List<RacerProgress> racerProgresses;

    public RaceLog(List<Car> cars) {
        racerProgresses = cars.stream()
                .map(RacerProgress::new)
                .toList();
    }

    public List<RacerProgress> getRacerProgresses() {
        return racerProgresses;
    }
}
