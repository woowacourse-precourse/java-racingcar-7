package racingcar.model.car;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private List<Car> carList;
    private static final int PROGRESS_CONDITION = 4;

    public void initCarRepository(String[] names){
        setCarList();
        addToCarList(names);
    }

    public List<Car> getCarList(){
        return carList;
    }

    private void setCarList(){
        carList = new ArrayList<Car>();
    }

    private void addToCarList(String[] names){
        for(String name : names){
            Car car = new Car(name);
            carList.add(car);
        }
    }

}
