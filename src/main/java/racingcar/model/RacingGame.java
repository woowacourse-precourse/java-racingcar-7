package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAllCars() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<String> getRoundResult() {
        return cars.stream()
                .map(car -> String.format("%s : %s", car.getName(), car.getPositionDisplay()))
                .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        if (cars.isEmpty()) {
            throw new IllegalStateException("참가한 자동차가 없습니다.");
        }
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .sorted()  // 우승자 이름 정렬 (일관성을 위해)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
