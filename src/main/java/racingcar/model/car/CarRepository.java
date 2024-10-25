package racingcar.model.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {
    private final List<Car> carList = new ArrayList<>();

    public void initCarRepository(String[] names){
        addToCarList(names);
    }

    public List<Car> getCarList(){
        return Collections.unmodifiableList(carList);
    }

    private void addToCarList(String[] names){
        for(String name : names){
            Car car = new Car(name);
            carList.add(car);
        }
    }
}
