package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarManager {

    private static final String INPUT_DELIMITER = ",";

    private List<Car> cars;

    public CarManager(){
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars(){
        return Collections.unmodifiableList(cars);
    }

    public void setupCarsFromUserInput(String userInput){
        List<String> split = List.of(userInput.split(INPUT_DELIMITER));
        initCars(split);
    }

    public List<Car> startRacing(int randomNumber) {
        for (Car car : cars) {
            car.move(randomNumber);
        }
        return cars;
    }

    private void initCars(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

}
