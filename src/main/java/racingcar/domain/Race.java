package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Constants;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void run(int times) {
        for (int i = 0; i < times; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        cars.forEach(car -> {
            int randomNumber = Randoms.pickNumberInRange(
                    Constants.RANDOM_NUMBER_MIN,
                    Constants.RANDOM_NUMBER_MAX
            );
            car.move(randomNumber);
        });
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return getWinnersWithPosition(maxPosition);
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<String> getWinnersWithPosition(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
