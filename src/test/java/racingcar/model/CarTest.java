package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 무작위_숫자가_4_이상일_때_자동차를_전진한다(){
        Car car = new Car("abc");
        car.run(4);
        Assertions.assertThat(car.getScore()).isEqualTo(1);
    }

    @Test
    void 무작위_숫자가_3_이하일_때_전진하지_않는다(){
        Car car = new Car("abc");
        car.run(3);
        Assertions.assertThat(car.getScore()).isEqualTo(0);
    }
}