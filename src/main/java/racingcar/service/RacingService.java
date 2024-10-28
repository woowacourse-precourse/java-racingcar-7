package racingcar.service;

import racingcar.factory.CarsFactory;
import racingcar.generator.Generator;
import racingcar.model.Car;
import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.strategy.MoveStrategy;

public class RacingService {
    private final MoveStrategy moveStrategy;
    private final Generator<Integer> generator;

    public RacingService(MoveStrategy moveStrategy, Generator<Integer> generator) {
        this.moveStrategy = moveStrategy;
        this.generator = generator;
    }

    public Cars initializeCars(CarNames carNames) {
        return CarsFactory.createCars(carNames);
    }
    
    // 매 라운드마다 호출되어 자동차 이동을 처리하는 메서드
    public void playRound(Cars cars) {
        for (Car car : cars.getCars()) {
            int number = generator.generate();
            car.move(moveStrategy.canMove(number));
        }
    }
}
