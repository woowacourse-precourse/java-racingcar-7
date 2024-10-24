package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("pobi");
        car.move(()-> {return 5;});
        assertThat(car).isEqualTo(new Car(new Name("pobi"),1));
    }
}
