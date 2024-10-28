package domain.car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.enums.ErrorMessage;

public class Cars {
    private final List<Car> carList;

    private Cars(final List<Car> carList) {
        validateDuplicateNames(carList);
        this.carList = carList;
    }

    public static Cars from(final List<Car> carList) {
        return new Cars(carList);
    }

    public int size() {
        return carList.size();
    }

    private void validateDuplicateNames(final List<Car> carList) {
        Set<String> carNames = new HashSet<>();
        for (Car car : carList) {
            if (!carNames.add(car.getName())) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
            }
        }
    }
}
