package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> carList = new ArrayList<>();

    public void setup(String inputCars) {
        String[] strCars = separateInputCars(inputCars);

        for (String str : strCars) {
            carList.add(new Car(str));
        }
    }

    public String[] separateInputCars(String input) {
        return input.split(",");
    }

    public List<Car> getCarList() {
        return this.carList;
    }
}
