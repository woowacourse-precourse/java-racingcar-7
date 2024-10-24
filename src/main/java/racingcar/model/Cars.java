package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<>();
    }

    public void addCar(Car target){
        carList.add(target);
    }

    public void addCarFromString(String input){
        String[] names = input.split(",");
        for(int i=0; i< names.length; i++){
            Car car = new Car(names[i], i);
            addCar(car);
        }
    }

    public void removeCar(Car target){
        carList.remove(target);
    }

    public List<Car> getCarList() {
        return this.carList;
    }
}
