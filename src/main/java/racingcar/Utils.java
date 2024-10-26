package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public List<Car> setParticipants(String[] splited) {
        List<Car> cars = new ArrayList<>();
        for (String carName : splited) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public boolean canMove() {
        int n = Randoms.pickNumberInRange(0, 9);
        if (n >= 4) {
            return true;
        }
        return false;
    }
}
