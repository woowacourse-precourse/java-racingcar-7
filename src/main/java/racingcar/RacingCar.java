package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {

    private final List<Car> cars;

    public RacingCar(List<Car> cars) {
        this.cars = cars;
    }

    public void run(int round) {
        RacingCarOutput.printRoundResultMessage();
        for (int i = 0; i < round; i++) {
            round();
        }
        RacingCarOutput.printWinners(findWinners());
    }

    private void round() {
        cars.forEach(car -> car.go(Randoms.pickNumberInRange(0, 9)));
        RacingCarOutput.printRoundResult(cars);
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("우승자를 찾을 수 없습니다."));
    }
}
