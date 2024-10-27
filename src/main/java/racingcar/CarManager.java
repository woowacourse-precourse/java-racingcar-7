package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarManager {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(String name, int advance){
        Car car = new Car(name, advance);
        cars.add(car);
    }

    public Car findCar(String name){
        return cars.stream()
                .filter(car1 -> car1.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public void moveCars(List<String> participants){
        for(String name: participants){
            Car car = findCar(name);

            int randomNo = pickNumberInRange(0, 9);
            if(randomNo >= 4) car.move();
        }
    }

    public void printState(List<String> participants){
        for(String name: participants){
            Car car = findCar(name);

            System.out.print(car.getName() + " : ");
            IntStream.range(0, car.getAdvance()).mapToObj(i -> "-").forEach(System.out::print);
        }
    }
}
