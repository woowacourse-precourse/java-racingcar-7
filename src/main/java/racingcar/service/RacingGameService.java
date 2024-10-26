package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.validation.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameService {
    public List<Car> createCars(String carNamesInput) {
        List<String> carNames = parseCarNames(carNamesInput);

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private List<String> parseCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        InputValidator.validateCarNames(carNames);
        return carNames;
    }

    public int parseMoveCount(String moveCountInput) {
        return InputValidator.validateMoveCount(moveCountInput);
    }

    public void startRace(List<Car> cars, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            raceOneRound(cars);
            printRoundResult(cars);
        }
    }

    private void raceOneRound(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.decideToMove(randomNumber);
        }
    }

    private void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
