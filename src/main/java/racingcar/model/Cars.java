package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars createCarList(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        List<Car> carList = new ArrayList<>();

        for (String name : carNames) {
            String carName = name.trim();
            carList.add(new Car(carName));
        }

        return new Cars(carList);
    }

    public void moveCars() {
        for (Car car : carList) {
            car.move();

        }

    }


    public List<Car> getCarList() {
        return carList;
    }

}
