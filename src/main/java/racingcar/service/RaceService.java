package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;


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
}
