package racingcar.domain;

import java.util.List;

public class Race {

    private Long lapLefts;
    private final List<Car> entry;

    public Race(Long lap, List<Car> preparedRacingCar) {
        lapLefts = lap;
        entry = preparedRacingCar;
    }

    public void completeALap() {
        lapLefts--;
    }

    public Long getLapLefts() {
        return lapLefts;
    }

    public List<Car> getEntry() {
        return entry;
    }
}
