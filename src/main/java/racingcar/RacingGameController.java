package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
    }

    public void play() {
        List<Car> cars = createCars(getValidatedCarNames());
        int attempts = getValidatedAttempts();

        race(cars, attempts);
        announceWinner(cars);
    }

    private String getValidatedCarNames() {
        String input = inputView.readCarNames();
        inputValidator.validateCarNames(input);
        return input;
    }

    private int getValidatedAttempts() {
        String input = inputView.readAttempts();
        inputValidator.validateAttempts(input);
        return Integer.parseInt(input);
    }

    private List<Car> createCars(String input) {
        return Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void race(List<Car> cars, int attempts) {
        outputView.printResultStart();
        for (int i = 0; i < attempts; i++) {
            moveAll(cars);
            outputView.printRoundResult(cars);
        }
    }

    private void moveAll(List<Car> cars) {
        cars.forEach(Car::move);
    }

    private void announceWinner(List<Car> cars) {
        outputView.printWinners(findWinners(cars));
    }

    private List<Car> findWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
