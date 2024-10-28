package racingcar.Factory;

import java.util.List;
import racingcar.Domain.CarManager;
import racingcar.Domain.RaceResultEvaluator;
import racingcar.Domain.RandomNumber;

public class DomainFactory {
    public CarManager createCarInfo(List<String> carNames) {
        return new CarManager(carNames);
    }

    public RaceResultEvaluator createRaceResultEvaluator() {
        return new RaceResultEvaluator();
    }

    public RandomNumber createRandomNumber() {
        return new RandomNumber();
    }
}
