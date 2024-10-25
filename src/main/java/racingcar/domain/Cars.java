package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import racingcar.util.ErrorMessage;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        checkCarNameDuplicate(carNames);
        this.cars = new ArrayList<>();
        carNames.forEach(carName -> cars.add(new Car(carName)));
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private void checkCarNameDuplicate(List<String> carNames) {
        HashSet<Object> set = new HashSet<>();
        carNames.forEach(carName -> {
            if (!set.add(carName)) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATED.getMessage() + carName);
            }
        });
    }
}
