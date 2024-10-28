package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String[] players) {
        cars = Arrays.stream(players)
                .map(player -> new Car(player.trim()))
                .toList();
    }

    public void run() {
        for (Car car : cars) {
            int randomNum = RandomNumberGenerator.generate();
            car.move(randomNum);

            displayPosition(car.getName(), car.getPosition());
        }
    }

    private static void displayPosition(String name, int position) {
        final String MOVING_SYMBOL = "-";
        System.out.println(name + " : " + MOVING_SYMBOL.repeat(position));
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
        public static int generate() {
            return Randoms.pickNumberInRange(0, 9);
        }
    }
}
