package racingcar.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car>{
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void add(Car car) {
        cars.add(car);
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
