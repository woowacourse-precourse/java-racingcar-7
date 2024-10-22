package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 자동차들_생성() {
        Cars cars = new Cars(List.of(new Car("hwan2"), new Car("hwan3")));
        assertThat(cars).isNotNull();
    }

    @Test
    void 자동차_중복검증() {
        assertThatThrownBy(() -> new Cars(List.of(new Car("hwan2"), new Car("hwan2"))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}