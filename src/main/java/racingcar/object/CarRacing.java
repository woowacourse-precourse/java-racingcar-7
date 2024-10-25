package racingcar.object;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.object.value.LapRecord;
import racingcar.object.value.RaceRecord;
import racingcar.object.value.TotalLapCount;

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
