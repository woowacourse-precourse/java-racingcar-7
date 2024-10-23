package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCar {

    public List<String> splitCarNamesByComma(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }
}
