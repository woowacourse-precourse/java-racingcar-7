package racingcar.common;

import racingcar.application.implement.WinnerIdentifier;
import racingcar.common.support.RacingCarConverter;
import racingcar.persistence.RacingCarHistoryRepository;
import racingcar.persistence.InMemoryRacingCarRepository;
import racingcar.common.support.ObjectConverter;
import racingcar.application.Game;
import racingcar.persistence.RacingCarRepository;
import racingcar.application.implement.CarRacing;
import racingcar.application.implement.RacingCarHistoryManager;
import racingcar.application.implement.RacingCarHistoryWriter;
import racingcar.application.implement.Racing;
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
