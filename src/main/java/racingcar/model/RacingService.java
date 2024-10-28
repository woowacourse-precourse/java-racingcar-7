package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class RacingService {
    public List<Car> convertNamesToCars(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void executeRound(List<Car> carList) {
        for (Car car : carList) {
            car.move(pickNumberInRange(0, 9));
        }
    }

    public List<Car> checkWinnerList(List<Car> carList) {
        int maxState = carList.stream()
                .mapToInt(Car::getState)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getState() == maxState)
                .collect(Collectors.toList());
    }
}
