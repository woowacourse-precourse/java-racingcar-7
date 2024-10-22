package racingcar.configuration;

import racingcar.NameSeparator;
import racingcar.Reader;
import racingcar.nameseparator.OriginSeparator;
import racingcar.reader.ConsoleReader;

public class AppConfig {

    public Reader reader() {
        return new ConsoleReader();
    }

    public NameSeparator nameSeparator() {
        return new OriginSeparator();
    }
}
