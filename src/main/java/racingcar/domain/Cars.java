package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utility.StringUtility;

public class Cars {
    public final List<Car> cars;

    public Cars(String raceCarNames){
        cars = new ArrayList<>();
        List<String> carNameList = StringUtility.splitStringToList(raceCarNames);
        for(String carName : carNameList){
            cars.add(new Car(carName));
        }
    }

    public int getCarCount(){
        return cars.size();
    }

    public void move() {
        for (Car car : cars){
            car.move();
        }
    }
}
