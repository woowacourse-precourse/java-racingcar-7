package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarRacingTest {

    private CarRacing carRacing;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        carRacing = new CarRacing();
        cars = new ArrayList<>();
        Car car1 = new Car();
        car1.setName("pobi");
        Car car2 = new Car();
        car2.setName("woni");
        cars.add(car1);
        cars.add(car2);
    }

    @Test
    void 자동차_전진_테스트(){
        int randomNum = 4;
        cars.get(0).move(randomNum);
        assertEquals(1, cars.get(0).getPosition());
    }

    @Test
    void 자동차_이동불가_테스트(){
        int randomNum = 3;
        cars.get(0).move(randomNum);
        assertEquals(0, cars.get(0).getPosition());
    }

    @Test
    void 단일_우승자_결정_테스트(){

        cars.get(0).move(1);
        cars.get(1).move(5);

        List<Car> result = new ArrayList<>();
        result.add(cars.get(1));

        assertEquals(result, carRacing.findWinners(cars));
    }

    @Test
    void 다수_우승자_결정_테스트(){

        cars.get(0).move(8);
        cars.get(1).move(5);

        List<Car> result = new ArrayList<>();
        result.add(cars.get(0));
        result.add(cars.get(1));

        assertEquals(result, carRacing.findWinners(cars));
    }
}
