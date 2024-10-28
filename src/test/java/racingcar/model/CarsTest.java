package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 자동차_이름_중복시_예외_처리() {
        Car car1 = new Car(new RandomEngine(), "pobi");
        Car car2 = new Car(new RandomEngine(), "pobi");

        assertThatThrownBy(() -> new Cars(List.of(car1, car2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차가_1대만_입력시_예외_처리() {
        Car car1 = new Car(new RandomEngine(), "pobi");

        assertThatThrownBy(() -> new Cars(List.of(car1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}