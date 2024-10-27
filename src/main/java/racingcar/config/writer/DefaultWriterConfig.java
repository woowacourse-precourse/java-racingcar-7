package racingcar.config.writer;

import racingcar.io.writer.SystemWriter;
import racingcar.io.writer.Writer;

public class DefaultWriterConfig implements WriterConfig {

    private final Writer writer;

    public DefaultWriterConfig() {
        this.writer = new SystemWriter();
    }

    public Writer getWriter() {
        return writer;
    }
}