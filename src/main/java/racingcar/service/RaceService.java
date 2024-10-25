package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceService {
    private List<Car> cars;

    public RaceService() {
        this.cars = new ArrayList<>();
    }

    public void init(String input) {
        List<String> nameList = Arrays.stream(input.split(",")).toList();
        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }
}
