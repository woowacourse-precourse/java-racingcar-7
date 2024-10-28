package racingcar.repository;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 해당 클래스는 자동차 정보를 저장하는 클래스 입니다.
 *
 * @author Kalsteve98
 * @since 1.0
 */
public class CarRepository {

    private final List<Car> cars = new ArrayList<>();

    /**
     * CarRepository에 Car 객체를 저장합니다.
     *
     * @param car
     */
    public void save(Car car) {
        cars.add(car);
    }

    /**
     * CarRepository에 저장된 모든 Car 객체를 반환합니다.
     *
     * @return Car 객체 리스트
     */
    public List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }
}
