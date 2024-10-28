package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RaceService {

    public String[] splitCarNames(String carNames) {
        validateInputCarNames(carNames);
        String[] splitNames = carNames.split(",");
        return splitNames;
    }

    public List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void validateInputCarNames(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        if (carNames.endsWith(",") || carNames.startsWith(",")) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
        }
        if (carNames.contains(",,")) {
            throw new IllegalArgumentException("연속된 콤마는 사용할 수 없습니다.");
        }
    }
}
