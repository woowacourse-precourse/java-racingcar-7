package racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static List<Car> carList = new ArrayList<>();

    public Cars(String[] carNames) {
        addCarName(carNames);
    }

    private void addCarName(String[] carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
    }

    public String getCarListValue(int index) {
        return carList.get(index).getCarName();
    }

    public int getCarListSize() {
        return carList.size();
    }
}
