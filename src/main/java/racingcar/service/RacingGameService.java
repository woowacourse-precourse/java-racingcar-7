package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.CarNameParser;
import racingcar.util.RandomUtil;
import racingcar.util.ValidUtil;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.ErrorMessages.CAR_COUNT_ERROR_MESSAGE;
import static racingcar.constant.ErrorMessages.CAR_NAME_DUPLICATE_ERROR_MESSAGE;
import static racingcar.constant.ServiceConstants.MIN_CAR_COUNT;

public class RacingGameService {
    public List<Car> createCarsWithUniqueName(String input) {
        List<String> carNames = CarNameParser.parse(input);
        validateCarCount(carNames);
        validateUniqueCarNames(carNames);
        return CarFactory.generateCars(carNames);
    }

    public void runRounds(int rounds, List<Car> cars) {
        for (int i = 0; i < rounds; i++) {
            moveCars(cars);
            OutputView.printRoundResult(cars);
        }
    }

    public List<String> selectWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = RandomUtil.generateRandomNumber();
            car.move(randomNumber);
        }
    }

    private void validateCarCount(List<String> carNames) {
        if (carNames.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateUniqueCarNames(List<String> carNames) {
        if (ValidUtil.isDuplicate(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
