package racingcar.application.service;

import java.util.List;
import racingcar.racing.CarRaceResult;
import racingcar.racing.CarRacer;
import racingcar.application.ObjectConverter;
import racingcar.application.Game;
import racingcar.application.RacingManager;
import racingcar.view.ApplicationView;

public class RacingCarGame implements Game {

    private final ApplicationView applicationView;
    private final RacingManager<CarRacer> racingManager;
    private final ObjectConverter<CarRacer> objectConverter;

    public RacingCarGame(ApplicationView applicationView,
            RacingManager<CarRacer> racingManager, ObjectConverter<CarRacer> objectConverter) {
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
        List<CarRacer> carRacers = objectConverter.toObjects(responseCars);
        racingManager.registerAll(carRacers);
    }

    private void playRacingCarGame() {
        int gameCount = applicationView.requestGameCount();
        racingManager.raceStart(gameCount);
    }

    private void printRaceResult() {
        CarRaceResult carRaceResult = racingManager.createRaceResult();

        List<String> racingHistories = carRaceResult.histories();
        applicationView.printRacingProgressResult(racingHistories);

        List<CarRacer> winners = carRaceResult.winners();
        String winnersName = objectConverter.toStringNames(winners);
        applicationView.printWinners(winnersName);

    }
}
