package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;

public class Race {
    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void runRace() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.forwardIfAboveFour(randomValue);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    // 우승 자동차 목록 반환
    public List<Car> getWinners() {

        // 최대 이동 거리 탐색
        Car maxCar = Collections.max(cars, Comparator.comparingInt(Car::getDistance));
        int maxDistance = maxCar.getDistance();

        // 최대 이동 거리를 이동한 car 모두 반환
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }

        return winners;
    }

}
