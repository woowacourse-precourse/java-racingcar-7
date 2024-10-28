package racingcar.application.service;

import java.util.List;
import racingcar.persistence.CarRaceHistory;
import racingcar.racing.CarRaceResult;
import racingcar.racing.RacingCar;
import racingcar.application.ObjectConverter;
import racingcar.application.Game;
import racingcar.application.RacingManager;
import racingcar.view.ApplicationView;

public class RacingCarGame implements Game {

    private final ApplicationView applicationView;
    private final RacingManager<RacingCar> racingManager;
    private final ObjectConverter<RacingCar> objectConverter;

    public RacingCarGame(ApplicationView applicationView,
            RacingManager<RacingCar> racingManager, ObjectConverter<RacingCar> objectConverter) {
        this.applicationView = applicationView;
        this.racingManager = racingManager;
        this.objectConverter = objectConverter;
    }

    @Override
    public void execute() {
        registerRacingCars();

        playRacingCarGame();

        printRaceResult();
    }

    private void registerRacingCars() {
        String responseCars = applicationView.requestInputCars();
        List<RacingCar> racingCars = objectConverter.toObjects(responseCars);
        racingManager.registerAll(racingCars);
    }

    private void playRacingCarGame() {
        int gameCount = applicationView.requestGameCount();
        racingManager.raceStart(gameCount);
    }

    private void printRaceResult() {
        CarRaceResult carRaceResult = racingManager.createRaceResult();
        printRacingProgressResult(carRaceResult.carRaceHistory());
        printWinners(carRaceResult.winners());
    }

    private void printRacingProgressResult(CarRaceHistory carRaceHistory) {
        applicationView.printRacingProgressResult(carRaceHistory.getHistories());
    }

    private void printWinners(List<RacingCar> winners) {
        String winnersName = objectConverter.toStringNames(winners);
        applicationView.printWinners(winnersName);
    }
}
