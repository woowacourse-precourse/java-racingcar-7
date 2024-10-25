package racingcar.car;

import static org.assertj.core.api.Assertions.*;
import static racingcar.global.constant.Config.MOVE_CONTROL_NUMBER;

import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 생성된_숫자가_4_미만_일_때_자동차_멈춤() {
        //given
        Cars cars = new Cars();
        cars.addCar("test");
        //when
        cars.move(() -> MOVE_CONTROL_NUMBER - 1);
        //then
        assertThat(cars.get(0).getPosition()).isEqualTo(0);
    }

    @Test
    void 생성된_숫자가_4_이상일_때_자동차_전진() {
        //given
        Cars cars = new Cars();
        cars.addCar("test");
        //when
        cars.move(() -> MOVE_CONTROL_NUMBER);
        //then
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
    }
}