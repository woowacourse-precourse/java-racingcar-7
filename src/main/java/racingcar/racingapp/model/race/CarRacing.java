package racingcar.racingapp.model.race;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.racingapp.model.car.Cars;
import racingcar.racingapp.model.value.vo.LapRecord;
import racingcar.racingapp.model.value.vo.RaceRecord;
import racingcar.racingapp.model.value.vo.TotalLapCount;

public class CarRacing {

    private final Lap lap;
    private final TotalLapCount totalLapCount;

    private CarRacing(Lap lap, TotalLapCount totalLapCount) {
        this.lap = lap;
        this.totalLapCount = totalLapCount;
    }

    public static CarRacing standBy(Cars cars, TotalLapCount totalLapCount) {
        return new CarRacing(new Lap(cars), totalLapCount);
    }

    public RaceRecord race() {
        return new RaceRecord(raceEachLap());
    }

    private List<LapRecord> raceEachLap() {
        return IntStream.rangeClosed(1, totalLapCount.lapCount())
                .mapToObj(eachLap -> launchEachLap())
                .toList();
    }

    private LapRecord launchEachLap() {
        lap.launchLap();
        return lap.submitRecords();
    }

}
