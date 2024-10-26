package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void Car_객체_생성() {
        Car car = new Car("pobi");
        assertThat(car).isEqualTo(new Car("pobi"));
    }
}
