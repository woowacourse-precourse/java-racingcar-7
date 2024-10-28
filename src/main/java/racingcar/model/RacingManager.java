package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;


public class RacingManager {
    public List<Car> parseCarNamesToCar(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveOrStop(List<Car> carList) {
        for (Car car : carList) {
            car.move(pickNumberInRange(0, 9));
        }
    }

    public List<Car> getWinners(List<Car> carList) {
        int maxDistance = 0;
        List<Car> winnerList = new ArrayList<>();
        for (Car car : carList) {
            int distance = car.getDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
                winnerList.clear();
                winnerList.add(car);
            } else if (distance == maxDistance) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }
}
