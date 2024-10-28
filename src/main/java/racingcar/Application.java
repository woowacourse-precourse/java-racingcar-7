package racingcar;

import java.util.List;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        List<Car> cars = inputHandler.getCarNames();
        int trialCount = inputHandler.getTrialCount();

        MoveStrategy moveStrategy = new RandomMoveStrategy();
        Race race = new Race(cars, trialCount, moveStrategy, outputHandler);

        race.startRace();
    }
}
