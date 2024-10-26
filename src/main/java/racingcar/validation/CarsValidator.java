package racingcar.validation;

import java.util.HashSet;
import java.util.Set;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsValidator implements Validator{
    @Override
    public void validate(Object requestingObject) {
        if (requestingObject.getClass() != Cars.class) {
            throw new IllegalStateException("Improper type requested Cars validation");
        }
        ValidationRequest<Cars> validationRequest = new ValidationRequest(requestingObject);
        Cars cars = validationRequest.getObject();

        validateNameDuplication(cars);
        validateCarsSize(cars);
    }

    private void validateNameDuplication(Cars cars) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (Car car : cars.getCars()) {
            if (!uniqueCarNames.add(car.getName())) {
                throw new IllegalArgumentException("중복되지 않은 이름을 입력해주세요.");
            }
        }
    }

    private void validateCarsSize(Cars cars) {
        if (cars.getCars().size() < 2) {
            throw new IllegalArgumentException("2개 이상의 차 이름을 입력해주세요.");
        }
    }
}
