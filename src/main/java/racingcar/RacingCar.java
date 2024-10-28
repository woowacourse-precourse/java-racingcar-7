package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.RaceJudge;
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

        performRace(racingCount, cars);

        judgeFinalWinner(raceJudge);
    }

    private List<String> getCarNameInputFromUser() {
        outputHandler.showRacingCarNameComment();
        return inputHandler.getCarNamesFromUser();
    }

    private int getCarNumberInputFromUser() {
        outputHandler.showRacingCarNumberComment();
        return inputHandler.getCarNumberFromUser();
    }

    private void performRace(int racingCount, List<Car> participants) {
        outputHandler.showResultComment();

        for (int i = 0; i < racingCount; i++) {
            participants.forEach(Car::drive);

            outputHandler.showRaceResults(participants);
        }
    }

    private void judgeFinalWinner(RaceJudge raceJudge) {
        List<String> winners = raceJudge.findFinalWinner();
        outputHandler.showRaceWinner(winners);
    }

}
