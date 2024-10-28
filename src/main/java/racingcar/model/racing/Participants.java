package racingcar.model.racing;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;
import racingcar.model.car.Car;

public class Participants {
    private final List<Car> participants;

    public Participants(List<Car> participants) {
        validateParticipants(participants);
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

    private void validateParticipants(List<Car> participants) {
        if (participants == null || participants.isEmpty()) {
            throw new RacingCarException(ErrorMessage.EMPTY_CAR_NAMES);
        }
        Set<String> distinctCarNames = participants.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());
        if (participants.size() != distinctCarNames.size()) {
            throw new RacingCarException(ErrorMessage.DUPLICATED_CAR_NAME);
        }
    }
}
