package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class BasicRacingGameService implements RacingGameService {
    public List<Car> parseNameList(List<String> nameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과하였습니다 - 이름: " + name);
            }
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

    public void moveCarRandomly(List<Car> cars) {
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                car.move();
            }
        }
    }
}
