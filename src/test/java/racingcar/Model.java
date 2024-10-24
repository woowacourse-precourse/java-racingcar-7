package racingcar;

import java.util.Arrays;
import java.util.List;

public class Model {

    List<String> getCarNames(String inputString) {
        List<String> carNames = Arrays.asList(inputString.split(","));
        return carNames;
    }
}
