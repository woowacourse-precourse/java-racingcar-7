package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void Car_객체_생성() {
        // given
        Car car = new Car("Benz");

        // when

        // then
        assertThat(car.getName()).isEqualTo("Benz");
        assertThat(car.getAdvanceCount()).isEqualTo(0);
    }

}
