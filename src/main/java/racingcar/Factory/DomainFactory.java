package racingcar.Factory;

import racingcar.Domain.CarInfo;
import racingcar.Domain.RaceResultEvaluator;
import racingcar.Domain.RandomNumber;

public class DomainFactory {
    public CarInfo createCarInfo() {
        return new CarInfo();  // 팩토리 내부에서 객체 생성
    }

    public RaceResultEvaluator createRaceResultEvaluator() {
        return new RaceResultEvaluator();
    }

    public RandomNumber createRandomNumber() {
        return new RandomNumber();
    }
}
