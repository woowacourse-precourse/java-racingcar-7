package controller;

import factory.CarFactory;
import java.util.List;
import model.Car;
import util.ParsingUtil;
import validator.attemptNumberValidator;
import validator.carNameValidator;
import view.InputView;

public class CarController {
    private final InputView inputView;
    private final CarFactory carFactory;

    public CarController(InputView inputView, CarFactory carFactory) {
        this.inputView = inputView;
        this.carFactory = carFactory;
    }

    public List<Car> getCarsFromUserInput() {
        String userInput = inputView.getCarNames();
        List<String> carNames = ParsingUtil.carNamesToList(userInput);
        carNameValidator.isValid(carNames); // 검증

        return createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        return carFactory.createCars(carNames);
    }

    public int getAttemptCount() {
        String input = inputView.getAttemptCount();
        attemptNumberValidator.checkAttempt(input); //검증
        return Integer.parseInt(input);
    }
}
