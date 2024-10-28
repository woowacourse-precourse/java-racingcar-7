package racingcar.common;

import racingcar.persistence.InMemoryRacingCarRepository;
import racingcar.application.Converter;
import racingcar.application.Game;
import racingcar.RacingCar;
import racingcar.application.service.RacingCarConverter;
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

    private RacingManager<RacingCar> racingManager() {
        return new RacingCarManager(InMemoryRacingCarRepository.getInstance());
    }

    private Converter<RacingCar> converter() {
        return new RacingCarConverter();
    }
}
