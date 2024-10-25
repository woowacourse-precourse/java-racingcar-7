package racingcar.car.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.model.Car;
import racingcar.car.validation.CarNameValidator;

// 자동차 이름 관련 로직을 처리하는 서비스
public class CarNameService {
    private final CarNameValidator carNameValidator;

    public CarNameService(CarNameValidator carNameValidator) {
        this.carNameValidator = carNameValidator;
    }

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            carNameValidator.validateCarName(carName);  // 자동차 이름 검증
            cars.add(new Car(carName));
        }
        return cars;
    }
}
