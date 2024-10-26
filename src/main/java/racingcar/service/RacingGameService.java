package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class RacingGameService {

    private final MoveService moveService;

    public RacingGameService(MoveService moveService) {
        this.moveService = moveService;
    }

    public List<Car> initialize(List<String> carNames, int attempt) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            List<Boolean> moveHistory = moveService.setMoveHistory(attempt);
            cars.add(new Car(carName, moveHistory));
        }

        return cars;
    }

    public void race(Car car, int stage) {
        List<Boolean> moveHistory = car.getMoveHistory();
        if (moveHistory.get(stage)) {
            car.increaseDistance();
        }
    }
}
