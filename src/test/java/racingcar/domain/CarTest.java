package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 자동차_이름을_가져온다() {
        assertThat(car.getName().carName()).isEqualTo("pobi");
    }

    @Test
    void 자동차의_초기위치는_0이다() {
        assertThat(car.getPosition().position()).isEqualTo(0);
    }

    @Test
    void 자동차가_이동할_수_있다() {
        NumberGenerator numberGenerator = () -> 4;
        car.move(numberGenerator);
        assertThat(car.getPosition().position()).isEqualTo(1);
    }

    @Test
    void 자동차가_이동하지_않는다() {
        NumberGenerator numberGenerator = () -> 3;
        car.move(numberGenerator);
        assertThat(car.getPosition().position()).isEqualTo(0);
    }
}