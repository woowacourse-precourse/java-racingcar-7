package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class CarManager {
    private static CarManager instance;
    private List<Car> carList;

    private CarManager() {}

    public static CarManager getInstance() {
        if (instance == null) {
            instance = new CarManager();
        }
        return instance;
    }

    public List<Car> getCars() {
        return carList;
    }

    public void makeCarList(String carName) {
        carList.add(new Car(carName));
    }

    public void getRandomNumber() {
        for (Car car : carList) {
            int num = Randoms.pickNumberInRange(0, 9);
            boolean moveForward = numCheck(num);
            if (moveForward) {
                car.carMove();
            }
        }
    }

    private boolean numCheck(int num) {
        return num >= 4;
    }
}
