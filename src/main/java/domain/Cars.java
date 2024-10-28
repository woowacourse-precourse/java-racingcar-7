package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.enums.ErrorMessage;

public class Cars {
    private final List<Car> carList;

    private Cars(List<Car> carList) {
        validateDuplicateNames(carList); // 중복 검증 추가
        this.carList = carList;
    }

    public static Cars from(List<Car> carList) {
        return new Cars(carList);
    }

    public int size() {
        return carList.size();
    }

    private void validateDuplicateNames(List<Car> carList) {
        Set<String> carNames = new HashSet<>();
        for (Car car : carList) {
            if (!carNames.add(car.getName())) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
            }
        }
    }
}
