package racingcar;

import racingcar.config.RaceGameConfig;
import racingcar.config.moveProvider.DefaultMoveProviderConfig;
import racingcar.config.reader.DefaultReaderConfig;
import racingcar.config.writer.DefaultWriterConfig;

public class Application {
    public static void main(String[] args) {
        RaceGameConfig raceGameConfig = new RaceGameConfig(
                new DefaultReaderConfig(),
                new DefaultWriterConfig(),
                new DefaultMoveProviderConfig()
        );
        RaceGame raceGame = new RaceGame(raceGameConfig);

        raceGame.play();
    }
}