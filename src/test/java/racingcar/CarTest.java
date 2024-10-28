package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 정상_입력() {
        Car car = new Car("good");

        assertThat(car.getCarName()).isEqualTo("good");
    }

    @Test
    void 이름이_5글자_초과할경우_예외처리() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 무작위_값이_4_이상일_경우_전진한다() {
        Car car = new Car("test");

        assertRandomNumberInRangeTest(() -> {
                    car.foward();
                },
                4
        );
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void 무작위_값이_4_미만일_경우_멈춰있는다() {
        Car car = new Car("test");

        assertRandomNumberInRangeTest(() -> {
                    car.foward();
                },
                3
        );
        assertThat(car.getDistance()).isEqualTo(0);
    }
}