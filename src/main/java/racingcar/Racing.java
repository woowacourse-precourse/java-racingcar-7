package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class Racing {
    private final Cars cars;
    private final int repeat;

    public Racing(Cars cars, int repeat) {
        this.cars = cars;
        this.repeat = repeat;
    }

    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < this.repeat; i++) {
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
        if (number >= 4) {
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
