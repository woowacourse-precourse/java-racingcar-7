package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class CarTest {
    @Test
    void 입력_테스트() {
        Car car = new Car("해건");
        assertThat(car.getName()).isEqualTo("해건");
    }

}
