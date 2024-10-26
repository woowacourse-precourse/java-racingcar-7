package racingcar.util;

import static racingcar.constant.RacingCarStatic.CAR_NAME_SEPARATOR;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor {

    public boolean hasMultipleCarNames(String input) {
        return input.contains(CAR_NAME_SEPARATOR);
    }
    
    public List<String> splitCarNames(String input) {

        List<String> carNames = new ArrayList<>();

        String[] names = input.split(CAR_NAME_SEPARATOR);

        for(String carName : names) {
            carNames.add(carName);
        }

        return carNames;
    }

}
