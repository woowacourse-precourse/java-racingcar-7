package controller;

import factory.CarFactory;
import java.util.List;
import model.Car;
import util.ParsingUtil;
import validator.carNameValidator;
import view.InputView;
import view.OutputView;

public class CarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarFactory carFactory;

    public CarController(InputView inputView, OutputView outputView, CarFactory carFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carFactory = carFactory;
    }

    public List<Car> getCarsFromUserInput() {
        outputView.printGuide();
        String userInput = inputView.getCarNames();
        List<String> carNames = ParsingUtil.CarNamesToList(userInput);
        carNameValidator.isValid(carNames); // 검증

        return createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        return carFactory.createCars(carNames);
    }

    public int getAttemptCount() {
        outputView.printAttemptPrompt();
        return inputView.getAttemptCount();
    }
}
