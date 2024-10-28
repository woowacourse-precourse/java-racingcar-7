package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.validator.RaceValidator;

public class Race {
    private final List<Car> cars;
    private final Integer totalRounds;

    public Race(List<Car> cars, int totalRounds) {
        RaceValidator.validate(cars);
        this.cars = cars;
        this.totalRounds = totalRounds;
    }

    public List<RoundResult> raceStart() {
        List<RoundResult> roundResults = new ArrayList<>();
        for (int i = 0; i < totalRounds; i++) {
            runOneRound();
            roundResults.add(new RoundResult(new ArrayList<>(cars)));
        }

        return roundResults;
    }

    public void runOneRound() {
        for (Car car : cars) {
            car.oneRoundStart();
        }
    }

    public List<Car> decideWinners() {
        Car leadingCar = findLeadingCar();
        return cars.stream()
                .filter(car -> car.isSamePositionAs(leadingCar))
                .toList();
    }

    private Car findLeadingCar() {
        Car leader = cars.get(0);
        for (Car car : cars) {
            if (leader == null || car.isAheadOf(leader)) {
                leader = car;
            }
        }
        return leader;
    }

}
