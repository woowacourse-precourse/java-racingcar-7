package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarManagerTest {

    @DisplayName("조건이 참이면 차가 한칸 전진 한다.")
    @Test
    void moveCarTest() {
        // given
        Car car = new Car("test");
        CarManager manager = new CarManager(() -> true);

        // when
        manager.moveCarsForward(List.of(car));

        // then
        assertThat(car.isPositionSameAs(1)).isTrue();
    }

    @DisplayName("조건이 거짓이면 차는 전진하지 않는다.")
    @Test
    void stopCarTest() {
        // given
        Car car = new Car("test");
        CarManager manager = new CarManager(() -> false);

        // when
        manager.moveCarsForward(List.of(car));

        // then
        assertThat(car.isPositionSameAs(0)).isTrue();
    }
}