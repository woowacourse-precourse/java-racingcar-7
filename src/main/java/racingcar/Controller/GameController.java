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
        for (int i = 0; i < roundCount; i++) {
            runRound();
            OutputView.printRoundResults(cars);
        }
        List<String> winners = determineWinners();
        OutputView.printWinners(winners);

    }

    public void endGame() {

    }

    private void setupCars() {
        String carNamesInput = InputView.InputCarNames();
        List<String> carNames = parseCarNames(carNamesInput);
        cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    private List<String> parseCarNames(String input) {
        List<String> carNames = List.of(input.split(","));
        Validator.checkCarNameLength(carNames);
        Validator.checkCarNamesUnique(carNames);
        return carNames;
    }


    private int getRoundCount() {
        int roundCount = InputView.InputRoundNumber();
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
