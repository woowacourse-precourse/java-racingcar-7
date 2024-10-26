package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarGameManager {
    public List<Car> cars;
    public int totalTimes;

    public CarGameManager(String[] names, int totalTimes) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.totalTimes = totalTimes;
    }

    public void startEachStep() {
        moveCars();
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (car.isMoved(randomNumber)) {
                car.move();
            }
        }
    }

    public List<Integer> getEachCarResultDistance() {
        ArrayList<Integer> carsDistance = new ArrayList<>();
        for (Car car : cars) {
            carsDistance.add(car.getDistance());
        }
        return carsDistance;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
