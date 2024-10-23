package racingcar.configuration;

import racingcar.nameseparator.OriginSeparator;
import racingcar.printer.PrintRacingResult;
import racingcar.racingapplication.NameSeparator;
import racingcar.racingapplication.Printer;
import racingcar.racingapplication.Reader;
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
}
