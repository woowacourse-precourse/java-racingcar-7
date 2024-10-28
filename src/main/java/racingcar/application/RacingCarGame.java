package racingcar.application;

import java.util.List;
import racingcar.application.service.RacingManager;
import racingcar.vo.CarRaceResult;
import racingcar.domain.CarRacer;
import racingcar.common.support.ObjectConverter;
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
