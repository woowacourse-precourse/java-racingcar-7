package racingcar.model;

import java.util.ArrayList;
import racingcar.model.dto.Car;

public class RaceStatus {
    private ArrayList<Car> carList;

    private RaceStatus() {
        carList = new ArrayList<>();
    }

    private static class SingletonHelper {
        private static final RaceStatus INSTANCE = new RaceStatus();
    }

    public static RaceStatus getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void setUpCar(String carName) {
        duplicateNameCheck(carName);

        carList.add(new Car(carName, 0));
    }

    private void duplicateNameCheck(String carName) {
        for (Car existingCar : carList) {
            String existingCarName = existingCar.getName();

            if (existingCarName.equals(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름은 사용할 수 없습니다.");
            }
        }
    }

    public void moveForward(int index) {
        Car currentCar = carList.get(index);
        int newDistance = currentCar.getDistance() + 1;

        currentCar.setDistance(newDistance);
    }

    public Car getCarByIndex(int index) {
        return carList.get(index);
    }

    public int getCarNumber() {
        return carList.size();
    }

    public void clearCarList() {
        carList.clear();
    }
}
