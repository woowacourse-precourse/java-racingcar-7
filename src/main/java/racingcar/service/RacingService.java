package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.Parser;

public class RacingService {

    public Cars createCars(String input) {
        return new Cars(extractCarsFromInput(input));
    }

    private List<Car> extractCarsFromInput(String input) {
        String[] nameElements = Parser.splitWithDelimiter(input);

        return Arrays.stream(nameElements)
                .map(element -> new Car(element.strip()))
                .distinct()
                .collect(Collectors.toList());
    }
}