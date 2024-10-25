package racingcar.domain.car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateCarName(cars);
        this.cars = new ArrayList<>(cars);
    }

    public void accelerateCars(Predicate<Car> moveCondition) {
        cars.forEach(car -> {
            if (moveCondition.test(car)) {
                car.accelerate();
            }
        });
    }

    public List<CarInfo> getCarInfos() {
        List<CarInfo> carInfos = new ArrayList<>();
        cars.forEach(car -> carInfos.add(car.getCarInfo()));
        return carInfos;
    }

    private void validateDuplicateCarName(List<Car> cars) {
        Set<Car> setCar = new HashSet<>(cars);
        if (setCar.size() != cars.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }
}
