package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test()
    @DisplayName("이름의 길이가 5초과면 예외를 던진다")
    void 이름_길이_검증_테스트() {
        String name = "123456";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car car = new Car(name);
        });
    }

    @Test()
    @DisplayName("난수가 4이상이면 전진한다")
    void 전진_테스트_4이상() {
        Car car = new Car("temp");

        car.go(4);

        assertThat(car).extracting("step").isEqualTo(1);
    }

    @Test()
    @DisplayName("난수가 4미만이면 전진하지 않는다")
    void 전진_테스트_4미만() {
        Car car = new Car("temp");

        car.go(3);
        assertThat(car).extracting("step").isNotEqualTo(1);
    }
}
