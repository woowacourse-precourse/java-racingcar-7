package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("출력 결과 확인 테스트")
    void carTest1() {
        // given
        String name = "car";
        Car car = new Car("car", 5L);

        // when
        String result = car.generateStatus();

        // then
        assertThat(result).isEqualTo(name + " : " + "-----");
    }

}
