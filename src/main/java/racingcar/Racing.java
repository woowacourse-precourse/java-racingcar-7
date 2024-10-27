package racingcar;

import java.util.List;

public class Racing {

    private final List<Car> carList;
    private final long attemptNumber;

    public Racing(List<Car> carList, long attemptNumber) {
        this.carList = carList;
        this.attemptNumber = attemptNumber;
    }

    public void race() {
        for (long round = 1; round <= attemptNumber; round++) {
            attemptMove();
        }
    }

    private void attemptMove() {
        carList.forEach(Car::tryMove);
    }
}
