package racingcar.domain;

import racingcar.utils.RandomNumber;

public class RacingGame {
    private final CarList carList;

    public RacingGame(String carNamesInput) {
        this.carList = new CarList(carNamesInput);
    }

    public void play(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            tryToMoveCars();
        }
    }

    private void tryToMoveCars() {
        for (Car car : carList.getCarList()) {
            car.tryToMove(RandomNumber.generate());
        }
    }

}
