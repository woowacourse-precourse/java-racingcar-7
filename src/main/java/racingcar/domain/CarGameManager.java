package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarGameManager {
    public ArrayList<Car> cars;
    public int totalTimes;

    public CarGameManager(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void start(String[] names, int totalTimes) {
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.totalTimes = totalTimes;

        for (int i = 0; i < totalTimes; i++) {
            startEachStep();
            System.out.println();
        }
    }

    private void startEachStep() {
        for (Car car : cars) {
            if (car.isMoved(Randoms.pickNumberInRange(0, 9))) {
                car.move();
            }
            car.printEachStep();
        }
    }

    public int getTotalCars() {
        return cars.size();
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
