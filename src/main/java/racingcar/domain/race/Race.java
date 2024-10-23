package racingcar.domain.race;

import racingcar.domain.car.Car;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

import java.util.List;

public class Race {

    private final static Integer MAX_VALUE = 9;
    private final static Integer MIN_VALUE = 1;
    public static final int NO_ACCESS_REPETITIONS = 1;

    private final RandomNumberGenerator defaultRandomNumberGenerator;

    public Race(RandomNumberGenerator defaultRandomNumberGenerator) {
        this.defaultRandomNumberGenerator = defaultRandomNumberGenerator;
    }

    public List<String> start(List<Car> cars, Integer repetitions) {
        if (repetitions < NO_ACCESS_REPETITIONS) {
            throw new BusinessException(RacingCarExceptionMessage.NAME_LENGTH_OUT_OF_RANGE);
        }

        repeatRacing(cars, repetitions);

        return findWinners(cars);
    }

    private void repeatRacing(List<Car> cars, Integer repetitions) {
        for (int i = 0; i < repetitions; i++) {
            Integer randomNumber = defaultRandomNumberGenerator.getRandomNumber(MIN_VALUE, MAX_VALUE);
            cars.forEach(car -> car.move(randomNumber));
        }
    }

    private List<String> findWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName) // getName() 호출
                .toList();
    }


}
