package racingcar.service;

import java.util.ArrayList;
import java.util.List;
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

    public void setUpRacing(String userInput) {
        this.carManager = new CarManager(
                CarCreator.createCars(InputParser.parserCarNames(userInput)));
    }

    public List<List<Car>> fullRacing(int count) {
        List<Car> cars = carManager.getCars();
        List<List<Car>> raceResults = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            raceResults.add(onceRacing(cars));
        }
        return raceResults;
    }

    private List<Car> onceRacing(List<Car> cars) {
        for (Car car : cars) {
            car.move(randomNumber.generate());
        }
        return new ArrayList<>(cars);
    }

    public String getWinners() {
        return winner.findWinner(carManager.getCars());
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
