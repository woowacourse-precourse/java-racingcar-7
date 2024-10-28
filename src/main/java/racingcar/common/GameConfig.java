package racingcar.common;

import racingcar.application.service.WinnerIdentifier;
import racingcar.application.service.RacingCarConverter;
import racingcar.persistence.RacingCarHistoryRepository;
import racingcar.persistence.InMemoryRacingCarRepository;
import racingcar.application.ObjectConverter;
import racingcar.application.Game;
import racingcar.persistence.RacingCarRepository;
import racingcar.racing.CarRacing;
import racingcar.racing.RacingCarHistoryManager;
import racingcar.racing.RacingCarHistoryWriter;
import racingcar.racing.Racing;
import racingcar.racing.CarRacer;
import racingcar.application.service.RacingCarGame;
import racingcar.application.service.RacingCarManager;
import racingcar.application.RacingManager;
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
        return new RacingCarManager(race(), racingCarRepository(), carRaceHistoryRecorder(), winnerIdentifier());
    }

    private RacingCarRepository racingCarRepository() {
        return InMemoryRacingCarRepository.getInstance();
    }

    private Racing<CarRacer> race() {
        return new CarRacing();
    }

    private RacingCarHistoryManager carRaceHistoryRecorder() {
        return new RacingCarHistoryManager(RacingCarHistoryRepository.getInstance(), new RacingCarHistoryWriter());
    }

    private WinnerIdentifier winnerIdentifier() {
        return new WinnerIdentifier();
    }
}
