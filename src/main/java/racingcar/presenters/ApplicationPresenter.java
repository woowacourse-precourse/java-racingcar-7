package racingcar.presenters;

import racingcar.models.Car;
import racingcar.utils.Randomizer;
import racingcar.validators.CarInputValidator;
import racingcar.validators.RoundInputValidator;
import racingcar.views.IOView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationPresenter {
    private final IOView view;
    private List<Car> cars;
    private int rounds;

    public ApplicationPresenter() {
        this.view = new IOView();
    }

    public void init() {
        String carInput = this.view.getCarInput();
        CarInputValidator carInputValidator = new CarInputValidator();
        carInputValidator.validate(carInput);

        String roundInput = this.view.getRoundInput();
        RoundInputValidator roundInputValidator = new RoundInputValidator();
        roundInputValidator.validate(roundInput);

        this.setupGame(carInput, roundInput);
    }

    private void setupGame(String carInput, String roundInput) {
        List<String> carNames = Arrays.asList(carInput.split(","));
        this.cars = carNames.stream().map(Car::new).toList();
        this.rounds = Integer.parseInt(roundInput);
    }

    public void runGame() {
        this.view.printResultsHeader();
        for (int i = 0; i < this.rounds; i++) {
            StringBuilder roundResults = new StringBuilder();
            for (Car car : this.cars) {
                car.makeMove(Randomizer.getRandomValue());
                roundResults.append(car.printMoves());
            }
            System.out.println(roundResults);
        }
    }

    public void displayResults() {
        int highestMove = this.cars.stream().mapToInt(Car::getMoves).max().getAsInt();
        List<Car> winners = this.cars.stream().filter(car -> car.getMoves() == highestMove).toList();
        String result = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        this.view.printWinners(result);
    }
}
