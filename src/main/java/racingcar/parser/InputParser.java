package racingcar.parser;

import racingcar.domain.Car;
import racingcar.domain.Input;
import racingcar.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final String DELIMITER = ",";
    private final InputValidator inputValidator;

    public InputParser(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    // TODO: 이름이 중복일경우, 메소드 최대한 작게 만들기
    public List<Car> splitCarsToList(final Input input) {
        List<Car> carList = new ArrayList<>();

        String cars = input.getInput();
        String[] carNames = cars.split(DELIMITER);

        for (String carName : carNames) {
            inputValidator.validateCarNameLength(carName);
            carList.add(new Car(carName));
        }
        return carList;
    }

    public int parseTryCount(final Input input) {
        try {
            int count = Integer.parseInt(input.getInput());
            inputValidator.validateTryCountGreaterZero(count);
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형태의 시도 횟수입니다.");
        }
    }

}
