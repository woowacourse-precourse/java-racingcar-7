package racingcar.Factory;

import java.util.List;
import racingcar.Domain.CarInfo;
import racingcar.Domain.RaceResultEvaluator;
import racingcar.Domain.RandomNumber;

public class DomainFactory {
    public CarInfo createCarInfo(List<String> carNames) {
        return new CarInfo(carNames);
    }

    public RaceResultEvaluator createRaceResultEvaluator() {
        return new RaceResultEvaluator();
    }

    public RandomNumber createRandomNumber() {
        return new RandomNumber();
    }
}
