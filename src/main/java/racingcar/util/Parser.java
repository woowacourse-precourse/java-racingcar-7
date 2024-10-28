package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Parser {
    private final Validator validator;

    public Parser(Validator validator) {
        this.validator = validator;
    }

    public List<Car> parseCarNames(String carNamesInput) {
        validator.validateNameEmpty(carNamesInput);

        String[] names = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            String trimName = name.trim(); // 이름 양 끝 공백 제거
            validator.validateNameLength(trimName);
            validator.validateNameDuplicate(trimName, cars);
            cars.add(new Car(trimName, ""));
        }

        return cars;
    }

    public int parseAttemptCount(String input) {
        validator.validateCountEmpty(input);
        try {
            int attemptCount = Integer.parseInt(input);
            validator.validatePositive(attemptCount);

            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("int 범위의 양수만 입력 가능합니다.");
        }
    }
}
