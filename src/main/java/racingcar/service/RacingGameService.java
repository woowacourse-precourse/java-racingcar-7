package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.validation.InputValidator;

import java.util.Arrays;
import java.util.List;

public class RacingGameService {
    public List<Car> createCars(String carNamesInput) {
        List<String> carNames = parseAndValidateCarNames(carNamesInput);
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public int parseMoveCount(String moveCountInput) {
        InputValidator.validateMoveCount(moveCountInput);
        return Integer.parseInt(moveCountInput);
    }

    public void raceOneRound(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.decideToMove(randomNumber);
        }
    }

    public List<Car> findWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<String> parseAndValidateCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        InputValidator.validateCarNames(carNames);
        return carNames;
    }
}
