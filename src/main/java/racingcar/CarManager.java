package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> cars = new ArrayList<>();

    public void addCar(String name, int advance){
        Car car = new Car(name, advance);
        cars.add(car);
    }

    public void moveCars(List<String> participants){

    }

    public void printState(List<String> participants){
        for(String name: participants){
            Car car = cars.stream()
                    .filter(car1 -> car1.getName().equals(name))
                    .findAny()
                    .orElse(null);
            if (car != null) {
                System.out.print(car.getName() + " : ");
                for(int i=0; i<car.getAdvance(); i++){
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }
}
