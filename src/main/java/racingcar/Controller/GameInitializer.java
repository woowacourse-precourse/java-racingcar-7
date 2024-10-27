package racingcar.Controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.model.RaceCars;
import racingcar.model.RoundCount;
import racingcar.view.InputView;

public class GameInitializer {
    public final InputView inputView;

    public GameInitializer(InputView inputView) {
        this.inputView = inputView;
    }

    public RaceCars createRaceCars() {
        List<String> carNames = inputView.getCarNames();
        List<Car> cars = carNames.stream().map(carName -> new Car(new Name(carName))).toList();
        return new RaceCars(cars);
    }

    public RoundCount getRoundCount() {
        String numberOfRounds = inputView.getRoundCount();
        return new RoundCount(numberOfRounds);
    }

}
