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

    private static InputStringReader reader;
    private static CarNamesConverter carNamesConverter;
    private static CountConverter countConverter;

    private static Display display;
    private static ForwardPolicy forwardPolicy;

    public static void main(String[] args) {
        configure();

        String rawCarNames = reader.readCarNames();
        List<Car> cars = carNamesConverter.convert(rawCarNames);

        String count = reader.readCount();
        int repetitions = countConverter.convert(count);

        Game game = Game.of(cars, display);
        game.start(repetitions, forwardPolicy);
    }

    private static void configure() {
        AppConfig appConfig = AppConfig.getInstance();

        reader = appConfig.inputStringReader();
        carNamesConverter = appConfig.carNamesConverter();
        countConverter = appConfig.countConverter();
        display = appConfig.display();
        forwardPolicy = appConfig.forwardPolicy();
    }
}
