package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarCreator;
import racingcar.domain.CarManager;
import racingcar.domain.InputParser;
import racingcar.domain.Winner;
import racingcar.utils.RandomNumber;
import racingcar.validation.Validator;


public class RacingService {

    private final Winner winner;
    private final RandomNumber randomNumber;
    private final Validator validation;
    private CarManager carManager;

    public RacingService(Winner winner, RandomNumber randomNumber, Validator validation) {
        this.winner = winner;
        this.randomNumber = randomNumber;
        this.validation = validation;
    }

    public void initCars(String userInput) {
        this.carManager = new CarManager(
                CarCreator.createCars(InputParser.parserCarNames(userInput)));
    }

    public List<Car> onceRacing() {
        List<Car> cars = carManager.getCars();
        return cars.stream()
                .peek(car -> car.move(randomNumber.generate()))
                .collect(Collectors.toList());
    }

    public String getWinners() {
        return winner.find(carManager.getCars());
    }

    public String getValidatedStringInput(String userStringInput) {
        validation.verifyUserInput(userStringInput);
        return userStringInput;
    }

    public int getValidateIntegerInput(String userIntegerInput) {
        validation.verifyRepeatCount(userIntegerInput);
        return Integer.parseInt(userIntegerInput);
    }

}
