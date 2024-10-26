package racingcar.validation;

import racingcar.model.Car;

public class CarValidator implements Validator{
    private static ValidationRequest<Car> validationRequest;
    @Override
    public void validate(Object requestingObject) {
        if (requestingObject.getClass() != Car.class) {
            throw new IllegalStateException("Improper type requested Cars validation");
        }
        validationRequest = new ValidationRequest(requestingObject);
        Car car = validationRequest.getObject();

        validateCarNameLengthAndBlank(car);
    }

    private void validateCarNameLengthAndBlank(Car car) {
        if (car.getName().isBlank()) {
            throw new IllegalArgumentException("이름으로 공백이나 빈 칸은 허용하지 않습니다.");
        }
        if (car.getName().length() > 5) {
            throw new IllegalArgumentException("이름은 5자리 이하로 입력해주세요.");
        }
    }
}
