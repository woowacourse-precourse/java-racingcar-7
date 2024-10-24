package racingcar.object;

import java.util.Comparator;
import java.util.List;
import racingcar.object.value.LapRecord;

public class Lap {

    private final List<Car> participants;

    public Lap(final List<Car> participants) {
        this.participants = List.copyOf(participants);
    }

    public LapRecord doLap() {
        participants.forEach(Car::tryDrive);
        return new LapRecord(participants.stream()
                .sorted(Comparator.comparing(Car::getCarName))
                .map(Car::record)
                .toList());
    }

}
