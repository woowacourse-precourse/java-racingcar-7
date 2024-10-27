package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarPosition;
import racingcar.dto.CarsPositions;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    private static Car createCar(String carName){
        return new Car(carName);
    }

    public List<Car> createCars(List<String> carNames){

        return carNames.stream()
                        .map(Cars::createCar)
                        .toList();

    }

    public void proceedOneRound(){
        for (Car car : cars) {
            MovementDecider movementDecider =  new MovementDecider();
            if (movementDecider.makeDecision()){
                car.move();
            }
        }
    }

    public CarsPositions buildCurrentStates(){
        List<CarPosition> carsPositions = new ArrayList<>();
        for (Car car : cars) {
            carsPositions.add(car.buildCarPosition());
        }

        return new CarsPositions(carsPositions);
    }

    public List<String> getWinner(){
        List<String> winners = new ArrayList<>();
        int highestPosition = 0;
        for (Car car : cars) {
            if (highestPosition < car.getPosition()) {
                highestPosition = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == highestPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
