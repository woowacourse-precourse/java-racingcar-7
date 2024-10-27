package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String[] players) {
        cars = Arrays.stream(players)
                .map(Car::new)
                .toList();
    }

    public void run() {
        for (Car car : cars) {
            int randomNum = RandomNumberGenerator.generate();
            car.move(randomNum);
            car.displayPosition();
        }
    }

    public String getWinners() {
        int winnerPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    private static class RandomNumberGenerator {
        private static final int MIN_RANDOM_VALUE = 0;
        private static final int MAX_RANDOM_VALUE = 9;

        public static int generate() {
            return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        }
    }
}
