package racingcar.testutil.config;

import racingcar.config.reader.ReaderConfig;
import racingcar.io.reader.Reader;

public class TestReaderConfig implements ReaderConfig {

    private final Reader reader;

    public TestReaderConfig(Reader reader) {
        this.reader = reader;
    }

    @Override
    public Reader getReader() {
        return reader;
    }
}