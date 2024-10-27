package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class GameController {
    private List<Car> cars;

    public void startGame() {
        try {
            setupCars();
            int roundCount = getValidatedRoundCount();
            for (int i = 0; i < roundCount; i++) {
                runRound();
                OutputView.printRoundResults(cars);
            }
            List<String> winners = determineWinners();
            OutputView.printWinners(winners);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setupCars() {
        String carNamesInput = InputView.InputCarNames();
        List<String> carNames = parseCarNames(carNamesInput);
        cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    private List<String> parseCarNames(String input) {
        List<String> carNames = List.of(input.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 하나 이상 입력해야 합니다.");
        }
        for (var name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
    }

    private int getValidatedRoundCount() {
        int roundCount = InputView.InputRoundNumber();
        if (roundCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return roundCount;
    }

    private void runRound() {
        for (var car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);

        }
    }

    private List<String> determineWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for (var car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        for (var car : cars) {
            if (maxPosition == car.getPosition()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
