package racingcar.config.reader;

import racingcar.io.reader.MissionUtilsReader;
import racingcar.io.reader.Reader;

public class DefaultReaderConfig implements ReaderConfig {

    private final Reader reader;

    public DefaultReaderConfig() {
        this.reader = new MissionUtilsReader();
    }

    public Reader getReader() {
        return reader;
    }
}