package domain;

import java.util.ArrayList;
import java.util.List;
import validator.CarValidator;

public class Cars {
    private final List<Car> carsList;

    public Cars(String carNames) {
        List<String> carsNameList = splitCars(carNames);
        CarValidator.checkMinimumCarCount(carsNameList);
        CarValidator.checkNoDuplicateNames(carsNameList);
        carsList = makeCarsList(carsNameList);
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    private List<String> splitCars(String input) {
        return List.of(input.split(","));
    }

    private List<Car> makeCarsList(List<String> carsNameList) {
        List<Car> carsList = new ArrayList<>();
        carsNameList.forEach(name -> carsList.add(new Car(name)));

        return carsList;
    }
}
