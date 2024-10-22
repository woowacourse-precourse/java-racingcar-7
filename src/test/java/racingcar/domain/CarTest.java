package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @Test
    void 자동차_생성() {
        Car car = new Car("hwan2");
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "hwan22"})
    void 자동차_이름_검증(String value) {
        assertThatThrownBy(() -> new Car(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_전진() {
        Car car = new Car("hwan2");
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_멈춤() {
        Car car = new Car("hwan2");
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}