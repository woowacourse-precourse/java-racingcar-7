package racingcar.config;

import racingcar.config.moveProvider.MoveProviderConfig;
import racingcar.config.reader.ReaderConfig;
import racingcar.config.writer.WriterConfig;
import racingcar.domain.car.CarFactory;
import racingcar.domain.race.RaceFactory;
import racingcar.domain.race.RaceManager;
import racingcar.io.RaceInputHandler;
import racingcar.io.RaceInputValidator;
import racingcar.io.RaceOutputHandler;
import racingcar.io.RaceResultParser;
import racingcar.io.RaceResultValidator;

public class RaceGameConfig {

    private final RaceInputHandler raceInputHandler;
    private final RaceOutputHandler raceOutputHandler;
    private final RaceManager raceManager;

    public RaceGameConfig(
            ReaderConfig readerConfig,
            WriterConfig writerConfig,
            MoveProviderConfig moveProviderConfig
    ) {
        this.raceInputHandler = new RaceInputHandler(
                readerConfig.getReader(),
                writerConfig.getWriter(),
                new RaceInputValidator()
        );
        this.raceOutputHandler = new RaceOutputHandler(
                writerConfig.getWriter(),
                new RaceResultParser(),
                new RaceResultValidator()
        );
        this.raceManager = new RaceManager(
                new CarFactory(),
                new RaceFactory(),
                moveProviderConfig.getMoveProvider()
        );
    }

    public RaceInputHandler getRaceInputHandler() {
        return raceInputHandler;
    }

    public RaceOutputHandler getRaceOutputHandler() {
        return raceOutputHandler;
    }

    public RaceManager getRaceManager() {
        return raceManager;
    }
}