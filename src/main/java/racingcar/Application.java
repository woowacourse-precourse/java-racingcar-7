package racingcar;

import java.util.List;
import racingcar.application.converter.CarNamesConverter;
import racingcar.application.converter.CountConverter;
import racingcar.domain.car.Car;
import racingcar.domain.car.ForwardPolicy;
import racingcar.domain.game.Display;
import racingcar.domain.game.Game;
import racingcar.io.InputStringReader;

public class Application {

    private static final AppConfig appConfig = AppConfig.getInstance();

    private static final InputStringReader reader = appConfig.inputStringReader();
    private static final CarNamesConverter carNamesConverter = appConfig.carNamesConverter();
    private static final CountConverter countConverter = appConfig.countConverter();

    private static final Display display = appConfig.display();
    private static final ForwardPolicy forwardPolicy = appConfig.forwardPolicy();

    public static void main(String[] args) {
        String rawCarNames = reader.readCarNames();
        List<Car> cars = carNamesConverter.convert(rawCarNames);

        String count = reader.readCount();
        int repetitions = countConverter.convert(count);

        Game game = Game.of(cars, display);
        game.start(repetitions, forwardPolicy);
    }
}
