package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {

    private final List<RacingCar> cars;
    private final int loopCount;

    public RacingGame(List<RacingCar> cars, int loopCount) {
        this.cars = cars;
        this.loopCount = loopCount;
    }

    public void start() {
        OutputView.printResult();
        for (int currentCount = 0; currentCount < loopCount; currentCount++) {
            playRound();
            printRoundResult();
        }
    }

    private void playRound() {
        cars.forEach(car -> {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random > 3) {
                car.move();
            }
        });
    }

    private void printRoundResult() {
        OutputView.printCarsStatus(cars);
        OutputView.printLineBreaking();
    }
}
