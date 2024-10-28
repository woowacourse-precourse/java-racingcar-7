package racingcar;

import java.util.List;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler input = new InputHandler();
        List<Car> cars = input.getCarNames();
        int trialCount = input.getTrialCount();

        startRace(cars, trialCount);

        OutputHandler output = new OutputHandler(cars);
        output.printTrialResult();
        output.printFinalWinner();
    }

    private static void startRace(List<Car> cars, int trialCount) {
        while (trialCount > 0) {
            for (Car car : cars) {
                car.move();
            }
            trialCount--;
        }

    }
}
