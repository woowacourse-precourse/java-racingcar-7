package racingcar;

import io.input.Input;
import io.output.Output;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceGameService {
    private final Input input;
    private final Output output;

    public RaceGameService(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        try {
            String carNamesInput = input.getCarNames();
            Cars cars = createCars(carNamesInput);

            int rounds = input.getRaceRounds();
            output.printStartMessage();

            for (int i = 0; i < rounds; i++) {
                cars.moveAll();
                output.printRoundResult(cars);
            }

            List<Car> winners = cars.getWinners();
            output.printWinners(winners);
        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e.getMessage());
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
