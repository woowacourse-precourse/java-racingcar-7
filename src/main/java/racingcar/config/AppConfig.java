package racingcar.config;

import racingcar.application.numbergenerator.RandomNumberForwardStrategy;
import racingcar.application.NameSeparator;
import racingcar.application.ForwardStrategy;
import racingcar.application.Printer;
import racingcar.application.Reader;
import racingcar.application.nameseparator.OriginSeparator;
import racingcar.application.printer.PrintRacingResult;
import racingcar.application.reader.ConsoleReader;

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

    public ForwardStrategy randomGenerator() {
        return new RandomNumberForwardStrategy();
    }
}
