package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static String delimiter = ",";

    private final List<Car> cars;

    public Cars(String inputCars) {
        this.cars = createCars(inputCars);
    }

    private List<Car> createCars(String inputCars) {
        carsValidator(inputCars);
        List<Car> carsList = new ArrayList<>();
        Set<String> carNamesSet = new HashSet<>();
        String[] carNames = inputCars.split(delimiter);

        for (String carName : carNames) {
            if (carNamesSet.contains(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + carName);
            }
            carNamesSet.add(carName);
            carsList.add(new Car(new CarName(carName)));
        }
        return carsList;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void carsValidator(String inputCars){
        if(inputCars.charAt(0) == ',' || inputCars.charAt(inputCars.length()-1) == ','){
            throw new IllegalArgumentException("자동차 이름의 입력은 ','로 시작하거나 끝날 수 없습니다");
        }
    }
}