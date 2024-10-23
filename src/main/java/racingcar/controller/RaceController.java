package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class RaceController {

    private final UIController uiController;

    public RaceController(UIController uiController) {
        this.uiController = uiController;
    }

    public void run() {
        Car car = new Car(uiController.receiveName());
        int count = uiController.receiveCount();

        uiController.printRaceResultPhrase();
        race(car, count);

        uiController.printWinner(car);
    }

    private void race(Car car, int count) {
        while (count-- > 0) {
            car.process(generateRandomValue());
            uiController.printRaceResult(car);
        }
    }

    private int generateRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
