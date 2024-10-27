package racingcar.testutil.config;

import racingcar.config.writer.WriterConfig;
import racingcar.io.writer.Writer;

public class TestWriterConfig implements WriterConfig {

    private final Writer writer;

    public TestWriterConfig(Writer writer) {
        this.writer = writer;
    }

    @Override
    public Writer getWriter() {
        return writer;
    }
}