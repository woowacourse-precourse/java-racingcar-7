package racingcar.model.racing;

import java.util.List;
import racingcar.model.car.Car;

public class Participants {
    private final List<Car> participants;

    public Participants(List<Car> participants) {
        this.participants = List.copyOf(participants);
    }


    public void moveCars() {
        participants.forEach(Car::move);
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public List<Car> findCarsWithMovedDistance(int distance) {
        return participants.stream()
                .filter(car -> car.getMovedDistance() == distance)
                .toList();
    }

    public int getMaxMovedDistance() {
        return participants.stream()
                .mapToInt(Car::getMovedDistance)
                .max()
                .orElse(0);
    }
}
