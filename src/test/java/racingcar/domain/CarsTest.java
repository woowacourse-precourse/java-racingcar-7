package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.ErrorMessage.CAR_QUANTITY_MAX;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 최대값보다_큰_자동차_수_예외_처리() {
        Set<Car> cars = new HashSet<>();
        for (int i = 0; i < 51; i++) {
            cars.add(new Car(i + ""));
        }

        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_QUANTITY_MAX.getMessage());
    }


}