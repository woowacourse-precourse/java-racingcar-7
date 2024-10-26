package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    public static Car createCar(String carName){
        return new Car(carName);
    }

    public List<Car> createCars(List<String> carNames){

        return carNames.stream()
                .map(Cars::createCar)
                .toList();
    }

    public void proceedOneRound(){
        for (Car car : cars) {
            if (MovementDecider.checkMoveOrNot()){
                car.move();
            }
        }
    }

    public List<String> getCurrentStates(){
        List<String> currentStates = new ArrayList<>();
        for (Car car : cars) {
            currentStates.add(car.getCurrentState());
        }

        return currentStates;
    }
}
