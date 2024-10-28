package racing.game;

import racing.game.domain.Car;
import racing.io.RacingInput;
import racing.io.RacingOutput;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private final RacingService racingService = new RacingService();
    private final RacingOutput racingOutput = new RacingOutput();
    private final RacingInput racingInput = new RacingInput();

    private List<Car> createCars(List<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        carNames.forEach(carName -> cars.add(new Car(carName)));

        return cars;
    }

    private void startRound(List<Car> cars) {
        cars.forEach(racingService::moveCarForward);
    }

    private void showRoundResult(List<Car> cars) {
        racingOutput.displayPositions(cars);
    }

    private void showWinner(List<Car> cars) {
        List<String> winnerNames = racingService.getWinnerNames(cars);
        racingOutput.displayWinners(winnerNames);
    }


    public void startRacingGame() {
        List<String> carNames = racingInput.getCarNames();
        List<Car> cars = createCars(carNames);
        int gameRound = racingInput.getGameRound();

        for (int roundNum = 0; roundNum < gameRound; roundNum++) {
            startRound(cars);
            showRoundResult(cars);
        }

        showWinner(cars);
    }
}
