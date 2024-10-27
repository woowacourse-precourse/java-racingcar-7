package racingcar;

import racingcar.config.RaceGameConfig;
import racingcar.domain.race.RaceManager;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResult;
import racingcar.io.RaceInputHandler;
import racingcar.io.RaceOutputHandler;

public class RaceGame {

    private final RaceInputHandler inputHandler;
    private final RaceOutputHandler outputHandler;
    private final RaceManager raceManager;

    public RaceGame(RaceGameConfig raceGameConfig) {
        this.inputHandler = raceGameConfig.getRaceInputHandler();
        this.outputHandler = raceGameConfig.getRaceOutputHandler();
        this.raceManager = raceGameConfig.getRaceManager();
    }

    public void play() {
        RaceRequest raceRequest = inputHandler.handle();
        RaceResult result = raceManager.startRace(raceRequest);
        outputHandler.handle(result);
    }
}