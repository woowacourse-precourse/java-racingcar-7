package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.response.Winners;
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

    public Winners findWinners(Cars cars) {
        List<Car> winningCars = new ArrayList<>();
        int maximum_distance = cars.findMaximumDistance();

        cars.getCars().forEach(car -> {
            if (car.matches(maximum_distance)) {
                winningCars.add(car);
            }
        });

        return new Winners(winningCars);
    }
}