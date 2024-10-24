package racingcar.service;

import java.util.List;
import racingcar.common.StringParser;
import racingcar.domain.Cars;

public class CarFactory {
    public Cars createCars(String string) {
        List<String> names = StringParser.splitByComma(string);
        return Cars.createCarsByNames(names);
    }
}
