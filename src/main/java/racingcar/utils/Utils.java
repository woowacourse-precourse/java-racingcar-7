package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

public class Utils {

    public String[] convertToCarNameArray(String carNames) {
        return carNames.split(",");
    }

    public void saveCarNamesToList(String[] carNames, List<Car> cars) {
        for (String carName : carNames) {
            cars.add(new Car(carName, ""));
        }
    }

    public void attemptCarMove(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.addCount();
        }
    }
}
