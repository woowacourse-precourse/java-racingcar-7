package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Cars {
    public static final int RANDOM_MIN_NUMBER = 0;
    public static final int RANDOM_MAX_NUMBER = 9;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    } // Cars

    public void move() {
        for (Car car : cars) {
            car.move(getPower());
        } // end for
    } // move

    public int getPower() {
        return Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
    } // getPower

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    } // getCars
} // class