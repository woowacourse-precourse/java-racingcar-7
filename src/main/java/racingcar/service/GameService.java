package racingcar.service;

import java.util.List;
import racingcar.model.Cars;
import racingcar.util.Parser;
import racingcar.util.Validator;

public class GameService {

    public Cars createCars(String input) {
        List<String> carNames = Parser.parseCars(input);
        Validator.carNameValidate(carNames);

        return Cars.of(carNames);
    }

}
