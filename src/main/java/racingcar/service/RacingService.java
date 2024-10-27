package racingcar.service;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.util.Parser;

public class RacingService {

    public Set<Car> createCars(String input) {
        List<Car> extractedCars = extractCarsFromInput(input);

        return new LinkedHashSet<>(extractedCars);
    }

    private List<Car> extractCarsFromInput(String input) {
        String[] nameElements = Parser.splitWithDelimiter(input);

        return Arrays.stream(nameElements)
                .map(element -> new Car(element.strip()))
                .toList();
    }
}