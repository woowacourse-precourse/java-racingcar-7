package racingcar;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.ForwardPolicy;
import racingcar.domain.game.Display;
import racingcar.domain.game.Game;
import racingcar.io.InputReader;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        InputReader inputReader = appConfig.inputReader();

        List<Car> cars = inputReader.readCarNames();
        int count = inputReader.readCount();

        Display display = appConfig.display();
        Game game = Game.of(cars, display);

        ForwardPolicy forwardPolicy = appConfig.forwardPolicy();
        game.start(count, forwardPolicy);
    }
}
