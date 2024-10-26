package racingcar.service;

import static racingcar.exception.ExceptionMessage.INVALID_INPUT_NUMBER;
import static racingcar.exception.ExceptionMessage.MINIMUM_RACING_TIME;
import static racingcar.exception.ExceptionMessage.USER_INPUT_NOT_NULL;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarCreator;
import racingcar.domain.CarManager;
import racingcar.domain.InputParser;
import racingcar.domain.Racing;
import racingcar.utils.RandomNumber;


public class RacingService {

    private static final String CHECK_NUMBER_REGEX = "\\d+";

    private CarManager carManager;
    private final Racing racing;
    private final RandomNumber randomNumber;

    public RacingService( Racing racing, RandomNumber randomNumber){
        this.racing = racing;
        this.randomNumber = randomNumber;
    }

    public void setUpRacing(String userInput) {
        List<Car> cars = CarCreator.createCars(InputParser.parserCarNames(userInput));
        this.carManager = new CarManager(cars);
    }

    public List<Car> startRacingOnce() {
        List<Car> cars = carManager.getCars();
        for (Car car : cars) {
            car.move(randomNumber.generate());
        }
        return cars;
    }

    public String getWinners() {
        return racing.findWinner(carManager.getCars());
    }


    public String getValidatedStringInput(String userStringInput) {
        verifyUserInput(userStringInput);
        return userStringInput;
    }

    public int getValidateIntegerInput(String userIntegerInput) {
        verifyRepeatCount(userIntegerInput);
        return Integer.parseInt(userIntegerInput);
    }

    private void verifyRepeatCount(String userInput) {
        if (!userInput.matches(CHECK_NUMBER_REGEX)) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER.getMessage());
        }
        if (Integer.parseInt(userInput) == 0) {
            throw new IllegalArgumentException(MINIMUM_RACING_TIME.getMessage());
        }
    }

    private void verifyUserInput(String userInput) {
        if (userInput.isBlank() || userInput == null) {
            throw new IllegalArgumentException(USER_INPUT_NOT_NULL.getMessage());
        }
    }

}
