package racingcar.io.page;

import racingcar.io.read.Reader;

public interface ReaderPage<PAGE, OUT> extends Reader<OUT>, Page<PAGE> {

    void setReader(Reader<OUT> reader);

    Reader<OUT> getReader();

    OUT getOutput();

}
