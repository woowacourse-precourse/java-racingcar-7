package racingcar.validation;

import racingcar.model.Car;

public class CarValidator implements Validator<Car>{
    @Override
    public void validate(Car car) {
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
