package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
}
