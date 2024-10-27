package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    private static final int MIN_MOVE_CONDITION = 4;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        String rawInputCarNames = inputView.inputCarNames();
        List<String> carNames = Arrays.asList(rawInputCarNames.split(","));
        Validator.validateCarNames(carNames);

        List<Car> carList = CarFactory.createCarByName(carNames);

        String rawRoundInput = inputView.inputRoundNumber();
        Validator.validateRoundCount(rawRoundInput);
        int roundCount = Integer.parseInt(rawRoundInput);

        outputView.printExecutionResult();
        runGameForRounds(roundCount, carList);

        List<String> finalWinner = findFinalWinner(carList);
        outputView.printFinalRacingResult(finalWinner);
    }

    private void runGameForRounds(int repeatNumber, List<Car> carList) {
        int randomValue;
        for (int i = 0; i < repeatNumber; i++) {
            for (Car car : carList) {
                randomValue = createRandomValue();
                if (randomValue >= MIN_MOVE_CONDITION) {
                    int currentForwardCount = car.getForwardCount();
                    car.setForwardCount(currentForwardCount + 1);
                }
            }
            outputView.printCurrentRoundRacingResult(carList);
        }
    }


    private int createRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private List<String> findFinalWinner(List<Car> cars) {
        List<String> finalWinner = new ArrayList<>();
        int winnerForwardCount = findWinnerForward(cars);
        for (Car car : cars) {
            if (car.getForwardCount() == winnerForwardCount) {
                finalWinner.add(car.getName());
            }
        }
        return finalWinner;
    }

    private int findWinnerForward(List<Car> cars) {
        return cars.stream().mapToInt(Car::getForwardCount).max().orElse(0);
    }

}
