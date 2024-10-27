package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


public class RaceService {

    public List<Car> makeCarList (String[] carNamesList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNamesList) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public void race (List<Car> carList) {
        for (Car car : carList) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.increaseLocation();
            }
        }
    }

    public int checkMaxLocation (List<Car> carList) {
        int maxLocation = 0;
        for (Car car : carList) {
            if (car.getLocation() >= maxLocation) {
                maxLocation = car.getLocation();
            }
        }
        return maxLocation;
    }

    public String checkWinner (List<Car> carList, int maxLocation) {
        StringJoiner winners = new StringJoiner(",");
        for (Car car : carList) {
            if (car.getLocation() == maxLocation) {
                winners.add(car.getCarName());
            }
        }
        return winners.toString();
    }
}
