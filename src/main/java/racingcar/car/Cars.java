package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.name.Name;
import racingcar.name.Names;
import racingcar.io.OutputManager;

public class Cars {

    private final List<Car> cars;

    public Cars(Names names) {
        List<Name> nameList = names.getNames();
        this.cars = getCars(nameList);
    }
    
    public void moveCars() {
        for (Car car : cars) {
            car.shellMove();
        }
    }

    public void printCurrentStatus() {
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

    public List<Car> getWinner(){
        List<Car> winners = new ArrayList<>();
        int winnerMovement = checkMaxMovement();

        for (Car car : cars) {
            if (isWinner(car, winnerMovement)){
                winners.add(car);
            }
        }

        return winners;
    }

    public int carsSize() {
        return cars.size();
    }

    private List<Car> getCars(List<Name> names) {
        List<Car> carList = new ArrayList<>();

        for (Name name : names) {
            carList.add(new Car(name));
        }

        return carList;
    }

    private static boolean isWinner(Car car, int winnerMovement) {
        return car.getStatus() == winnerMovement;
    }
}
