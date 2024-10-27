package racingcar.service;

import static racingcar.utils.StringSeparator.separate;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RoundCount;
import racingcar.domain.Winners;
import racingcar.domain.dto.CarsDto;
import racingcar.utils.RandomGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarService {
    private final RandomGenerator randomNumberGenerator;

    public RacingCarService(RandomGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Cars createCars(String inputNameString) {
        String[] carNames = separate(inputNameString);
        List<Car> carList = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(carList, randomNumberGenerator);
    }

    public RoundCount getRoundCount(String inputCountString) {
        int inputCount = Integer.parseInt(inputCountString);
        return new RoundCount(inputCount);
    }

    public void playRace(Cars cars, RoundCount roundCount) {
        cars.moveAll();
        roundCount.minusCount();
        if (!roundCount.isEnd()) {
            playRace(cars, roundCount);
        }
    }

    public CarsDto getCarsDto(Cars cars) {
        return cars.toDto();
    }

    public Winners getWinners(Cars cars) {
        return new Winners(cars.getWinners());
    }
}
