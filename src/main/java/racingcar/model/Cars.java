package racingcar.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return winnerCars.getCarList().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
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
