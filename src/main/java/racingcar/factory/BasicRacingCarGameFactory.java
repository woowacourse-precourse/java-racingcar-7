package racingcar.factory;


import racingcar.service.RacingCarGame;
import racingcar.util.generator.BasicRacingCarGenerator;
import racingcar.util.generator.BasicRacingCarGameRandomGenerator;
import racingcar.util.selector.BasicRacingCarGameWinnerSelector;
import racingcar.util.parser.BasicRacingCarNameParser;
import racingcar.util.transporter.BasicRacingCarTransporter;
import racingcar.util.validator.BasicRacingCarGameValidator;

public class BasicRacingCarGameFactory {
    public static RacingCarGame getRacingCarGame() {
        return new RacingCarGame(
                new BasicRacingCarNameParser(),
                new BasicRacingCarGameValidator(),
                new BasicRacingCarGenerator(),
                new BasicRacingCarTransporter(),
                new BasicRacingCarGameWinnerSelector(),
                new BasicRacingCarGameRandomGenerator()
        );
    }
}
