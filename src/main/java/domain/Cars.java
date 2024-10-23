package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carsList = new ArrayList<>();

    public Cars(String carNames) {
        carsList = splitCars(carNames);
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    private List<Car> splitCars(String input) {
        String[] names = input.split(",");

        List<Car> carsList = new ArrayList<>();
        for (String name : names) {
            carsList.add(new Car(name));
        }

        return carsList;
    }
}
