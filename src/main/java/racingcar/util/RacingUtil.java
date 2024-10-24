package racingcar.util;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingUtil {

    public static List<Car> getCarList(String input) {
        List<String> nameList = List.of(input.split(","));
        return nameList.stream()
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
}
