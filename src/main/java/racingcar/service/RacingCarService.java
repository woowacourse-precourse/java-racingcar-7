package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.enums.Delimiter;
import racingcar.validator.RacingCarValidator;

public class RacingCarService {

    private final RacingCarValidator validator = new RacingCarValidator();

    public List<Car> makeCarList(String inputString) {
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputString.split(Delimiter.COMMA.getSymbol());
        validator.validateCarNames(carNames);
        for (String carName : carNames) {
            validator.validateCarName(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }
}
