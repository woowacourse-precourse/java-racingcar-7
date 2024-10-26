package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;


public class RaceManager {
    private final RaceStorage raceStorage = new RaceStorage();

    public String race(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            raceACycle(cars);
        }

        return raceStorage.getResults();
    }

    public List<Car> getWinners(List<Car> cars) {
        int maxLocation = getMaxLocation(cars);
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .toList();
    }

    private void raceACycle(List<Car> cars) {
        cars.forEach(car -> {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                car.move();
            }
            raceStorage.addResult(car.toString());
        });

        raceStorage.addBlankLine();
    }

    private int getMaxLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("경주차가 존재하지 않습니다."));
    }


}
