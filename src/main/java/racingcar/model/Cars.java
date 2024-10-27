package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public String getWinner(){
        StringBuffer winner = new StringBuffer();
        carList.forEach(car -> {
            winner.append(car.getName());
        });
        return winner.toString();
    }

    public void addCar(Car target){
        carList.add(target);
    }

    public void addCarFromString(String input){
        String[] names = input.split(",");

        for(int i=0; i< names.length; i++){
            Car car = new Car(names[i].trim(), i);
            addCar(car);
        }
    }

}
