package racingcar.model;

import java.sql.Array;
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

    public Cars sortWinnerCars() {
        int maxDistance = WinnerCalculator.findMaxDistance(this.carList);

        carList.forEach(car -> {
            if(car.getDistance().getDistanceValue() < maxDistance){
                carList.remove(car);
            }
        });
        return this;
    }

    public String toStringWinnerCars(Cars winnerCars) {
        List<Car> winnerCarList = winnerCars.getCarList();
        List<String> winnerCarNames = new ArrayList<>();

        winnerCarList.forEach(car -> {
            winnerCarNames.add(car.getName());
        });

        return winnerCarNames.toString().replace("[","").replace("]", "");
    }

    public void addCar(Car target) {
        carList.add(target);
    }

    public void addCarFromString(String input) {
        String[] names = input.split(",");

        for(int i=0; i< names.length; i++){
            Car car = new Car(names[i].trim(), i);
            addCar(car);
        }
    }

}
