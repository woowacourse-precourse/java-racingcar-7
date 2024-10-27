package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("SwnB");
    }

    @Test
    void 자동차_전진_테스트() {
        // 전진 전에 count가 0인지 확인
        assertThat(car.getCount()).isEqualTo(0);

        // 전진 후 count 증가 확인
        car.move();
        assertThat(car.getCount()).isEqualTo(1);
    }

    @Test
    void 자동차_출력_테스트() {
        // 초기 상태 출력 확인
        assertThat(car.toString()).isEqualTo("SwnB : ");

        // 1회 전진 후 상태 출력 확인
        car.move();
        assertThat(car.toString()).isEqualTo("SwnB : -");

        // 2회 전진 후 상태 출력 확인
        car.move();
        assertThat(car.toString()).isEqualTo("SwnB : --");
    }
}
