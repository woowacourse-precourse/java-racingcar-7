package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.util.Validator;

public class GameController {
    private List<Car> cars;

    public void startGame() {
        setupCars();
        int roundCount = getRoundCount();
        runRounds(roundCount);
        endGame();
    }

    private void setupCars() {
        String carNamesInput = InputView.InputCarNames();
        List<String> carNames = parseCarNames(carNamesInput);
        cars = createCarList(carNames);
    }

    private List<String> parseCarNames(String input) {
        List<String> carNames = List.of(input.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        Validator.checkCarNameLength(carNames);
        Validator.checkCarNamesUnique(carNames);
    }

    private List<Car> createCarList(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int getRoundCount() {
        int roundCount = InputView.InputRoundNumber();
        validateRoundCount(roundCount);
        return roundCount;
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    private void runRounds(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            runRound();
            OutputView.printRoundResults(cars);
        }
    }

    private void runRound() {
        for (Car car : cars) {
            moveCarIfPossible(car);
        }
    }

    private void moveCarIfPossible(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        car.move(randomNumber);
    }

    public void endGame() {
        List<String> winners = determineWinners();
        OutputView.printWinners(winners);
    }

    private List<String> determineWinners() {
        int maxPosition = findMaxPosition();
        return findWinnersWithMaxPosition(maxPosition);
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<String> findWinnersWithMaxPosition(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
