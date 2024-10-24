package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>();
        cars.forEach(car -> {
            this.add(car);
        });
    }

    private void add(Car car){
        validateDuplicate(car);
        this.cars.add(car);
    }

    private void validateDuplicate(Car car){
        if(this.cars.contains(car)){
            throw new IllegalArgumentException("중복된 자동차가 존재합니다.");
        }
    }

    public int size() {
        return cars.size();
    }

}
