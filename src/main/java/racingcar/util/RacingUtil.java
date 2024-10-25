package racingcar.util;

import racingcar.domain.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingUtil {

    public static List<Car> getCarList(String input) {
        List<String> nameList = List.of(input.split(","));
        return nameList.stream()
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static void setMoveOrStop(List<Car> carList) {
        for (Car car : carList) {
            if (getRandomNumber()) {
                car.forward();
            }
        }
    }

    private static boolean getRandomNumber() {
        return pickNumberInRange(0, 9) >= 4;
    }

    public static List<String> findWinner(List<Car> carList) {
        int maxPosition = getWinnerPosition(carList);
        return getWinners(maxPosition, carList);
    }

    private static List<String> getWinners(int max, List<Car> carList) {
        return carList.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .toList();
    }

    private static int getWinnerPosition(List<Car> carList) {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get().getPosition();
    }
}
