package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public List<Car> inputCars() {
        List<String> carNames = inputView.getCarNames();
        InputValidator.validateForDuplicates(carNames);
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            name = name.trim();

            InputValidator.validateAlphaNumeric(name);
            InputValidator.validateMaxLength5(name);

            cars.add(new Car(name));
        }

        return cars;
    }

    public void announceWinners(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }

        outputView.printWinners(winners);
    }

    public int inputMoveCount() {
        return inputView.getMoveCount();
    }

    public void race(List<Car> cars, int moveCount) {
        outputView.printResult();

        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                evaluateMovement(car);
            }
            outputView.printCurrentStatus(cars);
        }
    }

    public void evaluateMovement(Car car) {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            car.move();
        }
    }

}
