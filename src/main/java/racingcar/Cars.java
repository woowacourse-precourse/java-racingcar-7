package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Name> cars) {
        this.cars = getCars(cars);
    }

    public List<Car> getCars(List<Name> names) {
        List<Car> carList = new ArrayList<>();

        for (Name name : names) {
            carList.add(new Car(name));
        }
        
        return carList;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void currentStatus() {
        for (Car car : cars) {
            OutputManager.printCurrent(car);
        }
    }

    public int checkMaxMovement(){
        int maxMovement = 0;
        for (Car car : cars) {
            if (maxMovement < car.getStatus()){
                maxMovement = car.getStatus();
            }
        }
        return maxMovement;
    }

    public List<Car> checkWinner(){
        List<Car> winners = new ArrayList<>();
        int winnerMovement = checkMaxMovement();

        for (Car car : cars) {
            if (car.getStatus() == winnerMovement){
                winners.add(car);
            }
        }

        return winners;
    }
}
