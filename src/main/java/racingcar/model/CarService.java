package racingcar.model;

import java.util.*;

public class CarService {
    private List<String> carNameList;
    private List<CarDto> cars = new ArrayList<>();


    public CarService(List<String> carNameList) {
        this.carNameList = carNameList;
    }


    private Boolean isOneName(){
        return carNameList.size() == 1;
    }

    private Boolean isSameName() {
        for (String name : carNameList) {
            if (Collections.frequency(carNameList, name) > 1) return true;
        }

        return false;
    }

    private List<CarDto> createCar() {
        if(isOneName()) carNameList.add("car");

        if (isSameName()) {
            carNameList.forEach(this::changeCarId);
            return cars;
        }

        carNameList.forEach(name -> cars.add(new CarDto(name)));

        return cars;
    }

    private void changeCarId(String name) {
        Map<String, Integer> repeat = new HashMap<>();

        int count = repeat.getOrDefault(name, 0) + 1;
        repeat.put(name, count);

        cars.add(new CarDto(name, count));
    }

    public CarDto forwardMovement(CarDto car, int forward) {
        return new CarDto(car.getName(), car.getId(), forward);
    }
}
