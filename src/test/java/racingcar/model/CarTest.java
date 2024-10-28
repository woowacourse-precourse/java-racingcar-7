package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 자동차_이름_설정() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_초기_위치() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이동_성공() {
        int newPosition = car.move(4);  // 전진 조건 충족 (4 이상)
        assertThat(newPosition).isEqualTo(4);
        assertThat(car.getPosition()).isEqualTo(4);
    }

    @Test
    void 이동_실패() {
        int newPosition = car.move(3);  // 전진 조건 미충족 (4 미만)
        assertThat(newPosition).isEqualTo(0);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 여러_번_이동() {
        car.move(4); // 첫 번째 이동, 전진 조건 충족
        car.move(5); // 두 번째 이동, 전진 조건 충족
        car.move(3); // 세 번째 이동, 전진 조건 미충족

        assertThat(car.getPosition()).isEqualTo(9); // 이동 성공 시의 총합 위치 확인
    }
}
