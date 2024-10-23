package racingcar.config;

import racingcar.RandomNumberGenerator;
import racingcar.application.NameSeparator;
import racingcar.application.NumberGenerator;
import racingcar.application.Printer;
import racingcar.application.Reader;
import racingcar.nameseparator.OriginSeparator;
import racingcar.printer.PrintRacingResult;
import racingcar.reader.ConsoleReader;

public class AppConfig {

    public Reader reader() {
        return new ConsoleReader();
    }

    public NameSeparator nameSeparator() {
        return new OriginSeparator();
    }

    public Printer printer() {
        return new PrintRacingResult();
    }

    public NumberGenerator randomGenerator() {
        return new RandomNumberGenerator();
    }
}
