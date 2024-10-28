package racingcar.domain.race;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.car.Car;
import racingcar.view.OutputView;

public class Race {
    private final List<Car> cars;
    private final Integer totalRounds;

    public Race(List<Car> cars, int totalRounds) {
        validateCarsDuplicate(cars);
        this.cars = cars;
        this.totalRounds = totalRounds;
    }

    private void validateCarsDuplicate(List<Car> cars) {
        Set<String> carNameSet = new HashSet<>();
        for (Car car : cars) {
            if (!carNameSet.add(car.getName())) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + car.getName());
            }
        }
    }

    public List<Car> raceStart() {
        for (int i = 0; i < totalRounds; i++) {
            runOneRound();
        }
        Car leadingCar = findLeadingCar();
        return decideWinners(leadingCar);
    }

    public void runOneRound() {
        for (Car car : cars) {
            car.oneRoundStart();
            OutputView.printRoundResults(cars);
        }
    }

    public Car findLeadingCar() {
        Car leader = cars.get(0);
        for (Car car : cars) {
            if (leader == null || car.isAheadOf(leader)) {
                leader = car;
            }
        }
        return leader;
    }

    public List<Car> decideWinners(Car leadingCar) {
        return cars.stream()
                .filter(car -> car.isSamePositionAs(leadingCar))
                .toList();
    }

}
