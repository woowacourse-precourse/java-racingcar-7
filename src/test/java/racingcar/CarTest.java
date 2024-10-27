package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move(){
        Car car = new Car("pobi", 0);
        car.move();
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }

}