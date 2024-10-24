package racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public Cars(String[] carNames) {
        addCarName(carNames);
    }

    private void addCarName(String[] carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
    }

    public Car getCar(int index) {
        return carList.get(index);
    }

    public String getCarListValue(int index) {
        return carList.get(index).getCarName();
    }

    public int getCarListSize() {
        return carList.size();
    }
}