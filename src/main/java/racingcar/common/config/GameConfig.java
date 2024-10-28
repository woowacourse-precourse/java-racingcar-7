package racingcar.common.config;

import racingcar.application.implement.RaceHistoryManager;
import racingcar.application.implement.CarRaceWinnerIdentifier;
import racingcar.application.implement.RaceWinnerIdentifier;
import racingcar.common.support.RacingCarConverter;
import racingcar.persistence.RacingCarHistoryRepository;
import racingcar.persistence.InMemoryCarRacerRepository;
import racingcar.common.support.ObjectConverter;
import racingcar.application.Game;
import racingcar.persistence.CarRacerRepository;
import racingcar.application.implement.CarRaceStarter;
import racingcar.application.implement.CarRaceHistoryManager;
import racingcar.application.implement.CarRaceHistoryWriter;
import racingcar.application.implement.RaceStarter;
import racingcar.domain.CarRacer;
import racingcar.application.RacingCarGame;
import racingcar.application.service.RacingCarManager;
import racingcar.application.service.RacingManager;
import racingcar.view.ApplicationConsoleView;
import racingcar.view.ApplicationView;

public class GameConfig {

    private static final GameConfig INSTANCE = new GameConfig();

    private GameConfig() {

    }

    public static GameConfig getInstance() {
        return INSTANCE;
    }

    public Game racingCarGame() {
        return new RacingCarGame(applicationView(), racingManager(), converter());
    }

    private ApplicationView applicationView() {
        return new ApplicationConsoleView();
    }

    private ObjectConverter<CarRacer> converter() {
        return new RacingCarConverter();
    }

    private RacingManager<CarRacer> racingManager() {
        return new RacingCarManager(race(), carRaceHistoryRecorder(), raceWinnerIdentifier(), racingCarRepository());
    }

    private CarRacerRepository racingCarRepository() {
        return InMemoryCarRacerRepository.getInstance();
    }

    private RaceStarter<CarRacer> race() {
        return new CarRaceStarter();
    }

    private RaceHistoryManager<CarRacer> carRaceHistoryRecorder() {
        return new CarRaceHistoryManager(RacingCarHistoryRepository.getInstance(), new CarRaceHistoryWriter());
    }

    private RaceWinnerIdentifier<CarRacer> raceWinnerIdentifier() {
        return new CarRaceWinnerIdentifier();
    }
}
