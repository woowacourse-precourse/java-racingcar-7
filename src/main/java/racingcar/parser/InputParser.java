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

        String cars = input.getCars();
        String[] carNames = cars.split(DELIMITER);

        for (String carName : carNames) {
            inputValidator.validateCarNameLength(carName);
            carList.add(new Car(carName));
        }
        return carList;
    }

}
