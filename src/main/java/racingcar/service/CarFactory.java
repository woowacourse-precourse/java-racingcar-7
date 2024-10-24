package racingcar.service;

import java.util.List;
import racingcar.common.StringUtil;
import racingcar.domain.Cars;

public class CarFactory {
    public Cars createCars(String string) {
        List<String> names = StringUtil.splitByComma(string);
        return Cars.createCarsByNames(names);
    }
}
