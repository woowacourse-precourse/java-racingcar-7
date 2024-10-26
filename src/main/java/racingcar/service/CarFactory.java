package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.common.StringUtil;
import racingcar.domain.Cars;

public class CarFactory {
    public Cars createCars(String string) {
        validateNoCar(string);
        List<String> names = StringUtil.splitByComma(string);
        validateNames(names);
        return Cars.createCarsByNames(names);
    }

    private void validateNoCar(String string) {
        if (string.trim().isBlank()) {
            throw new IllegalArgumentException("racer must more than one");
        }
    }

    private void validateNames(List<String> names) {
        Set<String> set = new HashSet<>(names);
        if (set.size() != names.size()) {
            throw new IllegalArgumentException("duplicate names included");
        }
    }
}
