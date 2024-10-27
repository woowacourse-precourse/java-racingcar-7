package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Participants {
    private final List<Car> participants;

    public Participants(List<Car> participants) {
        this.participants = List.copyOf(participants);
    }


    public void moveCarsRandomly() {
        participants.forEach(car -> {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        });
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

    public static Participants from(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return new Participants(cars);
    }
}
