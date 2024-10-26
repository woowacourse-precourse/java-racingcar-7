package racingcar.application;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.global.ProgressRule;
import racingcar.global.RandomRule;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final List<Car> cars;

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public void race(int trial) {
        for (int i = 0; i < trial; i++) {
            moveForwardIfShouldMove();
            OutputView.printCurrentProgress(cars);
        }
    }

    public void determineWinners() {
        int maxProgress = cars.stream()
                .mapToInt(car -> car.getProgressResult().length())
                .max()
                .orElse(0);

        cars.stream()
                .filter(car -> car.getProgressResult().length() == maxProgress)
                .forEach(Car::win);
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(Car::isWinner)  // 우승자로 설정된 자동차 필터링
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void moveForwardIfShouldMove() {
        cars.forEach(car -> {
            if (shouldMove()) {
                car.moveForward();
            }
        });
    }

    public boolean shouldMove() {
        int randomNumber = Randoms.pickNumberInRange(RandomRule.RANDOM_START.getValue(), RandomRule.RANDOM_END.getValue());
        return randomNumber >= ProgressRule.FORWARD_CONDITION.getValue();
    }
}
