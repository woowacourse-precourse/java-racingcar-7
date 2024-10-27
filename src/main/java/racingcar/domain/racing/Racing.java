package racingcar.domain.racing;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class Racing {

    private final int MINIMUM_MOVEABLE_VALUE = 4;

    private final Cars cars;
    private final RepeatCount repeat;

    public Racing(Cars cars, RepeatCount repeat) {
        this.cars = cars;
        this.repeat = repeat;
    }

    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < this.repeat.getValue(); i++) {
            race();
            printStatus();
        }
    }

    private void race() {
        for (Car car : this.cars.getCars()) {
            int distance = canMove();
            car.forward(distance);
        }
    }

    private int canMove() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= MINIMUM_MOVEABLE_VALUE) {
            return 1;
        }
        return 0;
    }

    private void printStatus() {
        System.out.println(this.cars);
    }

    public Cars getWinners() {
        return this.cars.findFarthestCars();
    }
}
