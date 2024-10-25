package Controller;

import View.InputView;
import View.OutputView;
import domain.Cars;
import domain.FindWinningCar;

import java.util.List;

public class CarRacingController {

    public void carRacingStart() {
        List<String> carNames = InputView.inputCarName();
        Cars cars = new Cars(carNames);

        int attemptNumber = InputView.inputAttemptNumber();

        for (int i = 0; i < attemptNumber; i++) {
            Cars.raceOnce(cars);
            OutputView.resultOfEveryRace(cars);
        }

        FindWinningCar findWinningCar = new FindWinningCar(cars.getCars());
        OutputView.resultOfFinalWinner(cars);
    }
}
