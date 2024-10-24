package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;


public class RaceManager {

    public String race(List<Car> cars) {
        StringBuilder raceResult = new StringBuilder();
        for (Car car : cars) {
            int random = Randoms.pickNumberInRange(0, 9);

            if (random >= 4) {
                car.move();
            }
            raceResult.append(car.toString()).append("\n");
        }
        raceResult.append("\n");
        return raceResult.toString();
    }

    public List<Car> getWinners(List<Car> cars) {
        int maxLocation = cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("경주차가 존재하지 않습니다."));

        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .toList();
    }
}
