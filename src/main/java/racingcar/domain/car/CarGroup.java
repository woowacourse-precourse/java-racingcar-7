package racingcar.domain.car;

import static racingcar.config.GameConfig.MAX_CARS_ALLOWED;
import static racingcar.utils.ExceptionConstants.DUPLICATE_CAR_NAME;
import static racingcar.utils.ExceptionConstants.EXCEEDS_MAX_CAR_LIMIT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        validateDuplicateCarName(cars);
        validateCarLimitExceeded(cars);
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
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getErrorMessage());
        }
    }

    private void validateCarLimitExceeded(List<Car> cars) {
        if (cars.size() > MAX_CARS_ALLOWED) {
            throw new IllegalArgumentException(EXCEEDS_MAX_CAR_LIMIT.getErrorMessage());
        }
    }
}
