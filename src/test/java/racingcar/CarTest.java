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
            assertThatThrownBy(() -> new Car("pobiiii"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 5자 이하의 문자열만 가능합니다.");
        });
    }

    @Test
    void 빈_이름_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new Car(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("빈 이름은 사용할 수 없습니다.");
        });
        assertSimpleTest(() -> {
            (assertThatThrownBy(() -> new Car("  "))
                    .isInstanceOf(IllegalArgumentException.class))
                    .hasMessageContaining("빈 이름은 사용할 수 없습니다.");
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new Car(" \n\n "))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("빈 이름은 사용할 수 없습니다.");
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new Car(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("빈 이름은 사용할 수 없습니다.");
        });
    }
}
