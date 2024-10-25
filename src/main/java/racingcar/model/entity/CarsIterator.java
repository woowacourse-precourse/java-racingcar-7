package racingcar.model.entity;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Cars 클래스의 Iterator를 구현함
 */
public class CarsIterator implements Iterator<Car> {

    private final Cars cars;

    private int index;

    public CarsIterator(Cars cars) {
        this.cars = cars;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < cars.getLength();
    }

    @Override
    public Car next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Car car = cars.getCarAt(index);
        index++;
        return car;
    }

}
