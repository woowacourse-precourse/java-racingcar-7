package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class CarManager {
    private static CarManager instance;
    private List<Car> carList;

    private CarManager() {
        carList = new ArrayList<>();
    }

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

    public void checkResult() {
        List<String> winners = new ArrayList<>();
        int maxNum = 0;

        for (Car car : carList) {
            int dist = car.getCarPosition();
            if (dist > maxNum) {
                winners.clear();
                winners.add(car.getCarName());
                maxNum = dist;
            }
            else if (dist == maxNum) {
                winners.add(car.getCarName());
            }
        }

        IOManager.printResult(winners);
    }

    public void reset() {
        carList.clear();
    }
}
