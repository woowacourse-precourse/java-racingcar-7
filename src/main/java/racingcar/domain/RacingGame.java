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
            printCurrentPositions();
        }
    }

    private void tryToMoveCars() {
        for (Car car : carList.getCarList()) {
            car.tryToMove(RandomNumber.generate());
        }
    }

    private void printCurrentPositions() {
        for (Car car : carList.getCarList()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }
}
