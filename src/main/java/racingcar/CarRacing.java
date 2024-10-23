package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRacing {

    public List<String> splitCarNamesByComma(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }

    public void validateCarName(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
