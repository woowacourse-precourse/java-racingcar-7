package racingcar.domain.race;

import java.util.List;
import racingcar.domain.car.Car;

public class RoundResult {
    private final List<Car> cars;

    public RoundResult(List<Car> cars) {
        this.cars = List.copyOf(cars);  // 불변 리스트로 저장
    }

    public List<Car> getCars() {
        return cars;
    }
}
