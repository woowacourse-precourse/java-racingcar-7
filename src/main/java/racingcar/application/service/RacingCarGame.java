package racingcar.application.service;

import java.util.List;
import racingcar.persistence.CarRaceHistory;
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
    public void play() {
        registerRacingCars();

        playRacingGame();

        printRacingProgressResult();
    }

    private void registerRacingCars() {
        String responseCars = applicationView.requestInputCars();
        List<RacingCar> racingCars = objectConverter.toObjects(responseCars);
        racingManager.registerAll(racingCars);
    }

    private void playRacingGame() {
        int gameCount = applicationView.requestGameCount();
        racingManager.raceStart(gameCount);
    }

    private void printRacingProgressResult() {
        CarRaceHistory carRaceHistory = CarRaceHistory.getInstance();
        applicationView.printRacingProgressResult(carRaceHistory.getHistories());
    }
}
