package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class RacingCarTest {
    @Test
    void racingCarMoveTest() {
        Car car1 = new Car("car1", 3);
        car1.move();
        assertEquals(car1.getLocation(), 4);
    }

    @Test
    void selectWinnerTest() {
        Referee referee = new Referee();
        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 4);
        Car car3 = new Car("car3", 5);

        car1.move();
        car1.move();
        car1.move();

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        ArrayList<String> winners = new ArrayList<>();
        winners.add(car1.getName());

        assertEquals(referee.selectWinners(cars), winners);
    }
}