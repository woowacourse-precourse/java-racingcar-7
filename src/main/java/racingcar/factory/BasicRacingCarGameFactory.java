package racingcar.factory;


import racingcar.service.RacingCarGame;
import racingcar.util.generator.BasicRacingCarGenerator;
import racingcar.util.generator.BasicRacingCarWinnerGenerator;
import racingcar.util.parser.BasicRacingCarNameParser;
import racingcar.util.transporter.BasicRacingCarTransporter;
import racingcar.util.validator.BasicRacingCarValidator;

public class BasicRacingCarGameFactory {
    public static RacingCarGame getRacingCarGame(){
        return new RacingCarGame(
                new BasicRacingCarNameParser(),
                new BasicRacingCarValidator(),
                new BasicRacingCarGenerator(),
                new BasicRacingCarTransporter(),
                new BasicRacingCarWinnerGenerator()
        );
    }
}
