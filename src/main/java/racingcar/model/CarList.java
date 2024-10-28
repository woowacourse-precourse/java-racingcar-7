package racingcar.model;

import java.util.ArrayList;

public class CarList {

    private final ArrayList<Car> carList;

    public CarList(){
        this.carList = new ArrayList<>();
    }

    public void addCar(Car car){
       carList.add(car);
    }

    public void play(){
        goCars();
        ArrayList<String> roundResults = new ArrayList<>();
        for (Car car : carList) {
            roundResults.add(car.playResult());
        }
        //출력
    }

    private void goCars(){
        carList.forEach(Car::go);
    }
}
