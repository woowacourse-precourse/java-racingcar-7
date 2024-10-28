package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<String> nameList) {
        this.carList = setCarList(nameList);
    }

    private List<Car> setCarList(List<String> nameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : nameList) {
            carList.add(new Car(name, 0));
        }
        return carList;
    }

    public void moveAll() {
        carList.forEach(Car::forwardOrStop);
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Car car : carList){
            str.append(car.toString()).append("\n");
        }
        return str.toString();
    }
}
