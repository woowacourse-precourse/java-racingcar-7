package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("성공 : 자동차 이름과 위치 초기화 테스트")
    @Test
    void 자동차_이름과_위치_초기화_테스트() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("성공 : 랜덤 값이 4 이상일 때 자동차가 한 칸 전진한다")
    @Test
    void 자동차_한_칸_전진_성공_테스트() {
        Car car = new Car("pobi");

        car.move(5);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("성공 : 랜덤 값이 4 미만일 때 자동차가 전진하지 않는다")
    @Test
    void 자동차_한_칸_전진_미실행_테스트() {
        Car car = new Car("pobi");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

}
