package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private final List<Car> cars;

    public CarRace(String carNames) {
        this.cars = createCars(carNames);
    }

    // 입력받은 자동차 이름 문자열을 쉼표로 분리하여 Car 객체 리스트 생성
    private List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}