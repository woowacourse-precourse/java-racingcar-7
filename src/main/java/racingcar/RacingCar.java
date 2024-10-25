package racingcar;

import java.util.List;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

public class RacingCar {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingCar(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        List<String> carNames = getCarNameInputFromUser();
        int racingCount = getCarNumberInputFromUser();

        List<Car> cars = Car.toList(carNames);
        RaceJudge raceJudge = RaceJudge.of(cars);

        for (int i = 0; i < racingCount; i++) {
            cars.forEach(Car::drive);

            raceJudge.determineWinners();

            outputHandler.showRaceResults(cars);
        }

        List<String> winners = raceJudge.findFinalWinner();
        outputHandler.showRaceWinner(winners);
    }

    private List<String> getCarNameInputFromUser() {
        outputHandler.showRacingCarNameComment();
        return inputHandler.getCarNamesFromUser();
    }

    private int getCarNumberInputFromUser() {
        outputHandler.showRacingCarNumberComment();
        return inputHandler.getCarNumberFromUser();
    }

}
