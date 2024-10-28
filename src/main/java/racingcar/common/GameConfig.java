package racingcar.common;

import racingcar.application.service.WinnerIdentifier;
import racingcar.application.service.RacingCarConverter;
import racingcar.persistence.CarRaceHistory;
import racingcar.persistence.InMemoryRacingCarRepository;
import racingcar.application.ObjectConverter;
import racingcar.application.Game;
import racingcar.persistence.RacingCarRepository;
import racingcar.racing.CarRace;
import racingcar.racing.CarRaceHistoryRecorder;
import racingcar.racing.Race;
import racingcar.racing.RacingCar;
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

    private ObjectConverter<RacingCar> converter() {
        return new RacingCarConverter();
    }

    private RacingManager<RacingCar> racingManager() {
        return new RacingCarManager(race(), racingCarRepository(), new WinnerIdentifier());
    }

    private RacingCarRepository racingCarRepository() {
        return InMemoryRacingCarRepository.getInstance();
    }

    private Race<RacingCar> race() {
        return new CarRace(carRaceHistoryRecorder());
    }

    private CarRaceHistoryRecorder carRaceHistoryRecorder() {
        return new CarRaceHistoryRecorder(CarRaceHistory.getInstance());
    }
}
