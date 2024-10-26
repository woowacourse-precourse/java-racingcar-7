package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.Utils;

public class UserInputData {
    private final List<Car> cars;
    private final int tryCount;

    public UserInputData(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public static List<Car> createCarByString(String inputString) {
        List<Car> cars = Stream.of(inputString)
                .map(Utils::splitInputStringsByComma)
                .flatMap(names -> Car.createCarsByNames(names).stream())
                .toList();
        return cars;
    }

    public static void tryingMoveCars(int tryCount, List<Car> cars) {
        for (int i = 0; i < tryCount; i++) {
            cars.stream()
                    .forEach(car -> {car.moveRandomly(if60PercentChance());});
        }
    }

    public static List<String> getWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .forEach(winners::add);

        return winners;
    }

    private static boolean if60PercentChance() {
        int pickNumberInRange = Randoms.pickNumberInRange(0, 9);
        if (pickNumberInRange >= 4) {
            return true;
        }
        return false;
    }
}
