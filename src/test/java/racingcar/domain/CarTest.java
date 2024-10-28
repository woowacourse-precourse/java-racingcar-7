package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차_생성_테스트() {
        // given
        String name = "pobi";
        // when
        Car car = new Car(name);
        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
