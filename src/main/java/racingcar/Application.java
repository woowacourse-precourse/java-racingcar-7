package racingcar;

import racingcar.domain.Car;
import racingcar.util.CarNameParser;
import racingcar.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.readCarNames();
        int attempt = InputView.readAttempt();

        CarNameParser parser = new CarNameParser();
        List<Car> cars = parser.parse(carNames);
    }
}
