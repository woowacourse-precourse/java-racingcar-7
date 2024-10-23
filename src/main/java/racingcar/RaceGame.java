package racingcar;

import io.input.impl.InputConsole;
import io.output.impl.OutputConsole;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceGame {
    public void start() {
        try {
            String carNamesInput = InputConsole.getCarNames();
            Cars cars = createCars(carNamesInput);

            int rounds = InputConsole.getRaceRounds();
            OutputConsole.printStartMessage();

            for (int i = 0; i < rounds; i++) {
                cars.moveAll();
                OutputConsole.printRoundResult(cars);
            }

            List<Car> winners = cars.getWinners();
            OutputConsole.printWinners(winners);
        } finally {

        }
    }

    private Cars createCars(String input) {
        List<Car> carList = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(CarName::new)
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(carList);
    }
}
