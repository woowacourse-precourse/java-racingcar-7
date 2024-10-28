package racingcar.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.randomgenerator.RandomGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    static class MoveRandomGenerator implements RandomGenerator {
        @Override
        public int random(int boundary) {
            return 4;
        }
    }

    static class StopRandomGenerator implements RandomGenerator {
        @Override
        public int random(int boundary) {
            return 0;
        }
    }
    @Test
    void move_success() {
        //given
        Car car = new Car("test", new MoveRandomGenerator());
        int origin = car.position;
        //when
        car.move();
        //then
        Assertions.assertAll(
                () -> assertEquals(origin + 1, car.position)
        );
    }
    @Test
    void move_fail(){
        Car car = new Car("test", new StopRandomGenerator());
        int origin = car.position;
        car.move();
        Assertions.assertAll(
                () ->assertEquals(origin, car.position)
        );
    }
    @Test
    void isWinner_success(){
        //given
        Car car = new Car("test", new MoveRandomGenerator());
        int winnerPosition = 5;
        car.position = winnerPosition;
        //when
        boolean result = car.isWinner(winnerPosition);
        //then
        Assertions.assertTrue(result);
    }
    @Test
    void isWinner_fail(){
        //given
        Car car = new Car("test", new MoveRandomGenerator());
        int winnerPosition = 5;
        car.position = 4;
        //when
        boolean result = car.isWinner(winnerPosition);
        //then
        Assertions.assertFalse(result);
    }
}
