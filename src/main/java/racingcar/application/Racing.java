package racingcar.application;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.List;

public class Racing {

    private final List<Car> cars;

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public void race(int trial) {
        for (int i = 0; i < trial; i++) {
            cars.forEach(car -> {
                if (shouldMove()) {
                    car.moveForward();
                }
            });
            OutputView.printCurrentProgress(cars);
        }
    }

    public boolean shouldMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
