package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void 객체_생성() {
        car = new Car("pobi");
    }

    @Test
    void 자동차_이름_설정_확인() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 초기_거리_확인() {
        assertThat(car.getMoveDisctance()).isEqualTo(0);
    }

    @Test
    void 랜덤_숫자_4_이상_이동_확인() {
        car.move(4);
        assertThat(car.getMoveDisctance()).isEqualTo(1);
    }

    @Test
    void 랜덤_숫자_4_미만_이동하지_않음() {
        car.move(3);
        assertThat(car.getMoveDisctance()).isEqualTo(0);
    }
}