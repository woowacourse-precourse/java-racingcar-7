package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    void 차량_이름_5자_이하_테스트() {
        assertThatThrownBy(() -> new Car("porsche"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void 전진하기_테스트() {
        Car car = new Car("pobi");
        for (int i = 0; i < 3; i++) {
            car.move();
        }

        assertEquals(3, car.getPosition());
    }
}
