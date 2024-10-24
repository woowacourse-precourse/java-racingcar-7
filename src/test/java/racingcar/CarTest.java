package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 이동거리_증가() {
        assertSimpleTest(() -> {
            Car car = new Car("pobi");
            car.increaseDistance();
            assertThat(car.toString()).isEqualTo("pobi : -");
        });

        assertSimpleTest(() -> {
            Car car = new Car("woni");
            car.increaseDistance();
            car.increaseDistance();
            assertThat(car.toString()).isEqualTo("woni : --");
        });
    }

    @Test
    void 이름_길이_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Car.validateNameLength("pobiiii"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 빈_이름_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Car.validateEmptyName(""))
                    .isInstanceOf(IllegalArgumentException.class);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Car.validateEmptyName("  "))
                    .isInstanceOf(IllegalArgumentException.class);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Car.validateEmptyName("\n\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> Car.validateEmptyName(null))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
}
