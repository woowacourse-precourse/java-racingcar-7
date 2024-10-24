package racingcar.domain.car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateCarName(cars);
        this.cars = cars;
    }

    public void accelerateSpecificCar(Car car) {
        car.accelerator();
    }

    private void validateDuplicateCarName(List<Car> cars) {
        Set<Car> setCar = new HashSet<>(cars);
        if (setCar.size() != cars.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }
}
