package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * trim
 */
public class CarsRegistrar {

    public Cars registerCars(String input) {
        Set<Car> carsList = new HashSet<>();

        for (String carName : getParsedCarNames(input)) {
            carsList.add(new Car(carName));
        }

        return new Cars(carsList);
    }

    private static List<String> getParsedCarNames(String carNames) {
        List<String> result = new ArrayList<>();
        String[] splitWord = carNames.split(",");
        for (String s : splitWord) {
            result.add(s.trim());
        }
        return result;
    }


}
