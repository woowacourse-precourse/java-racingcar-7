package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.ErrorMessage.CAR_NAME_DUPLICATE;
import static racingcar.domain.ErrorMessage.INPUT_CAR_EMPTY;

import org.junit.jupiter.api.Test;

class CarsFactoryTest {

    private final CarsFactory carsFactory = new CarsFactory();

    @Test
    void 자동차_이름_공백_예외처리() {
        assertThatThrownBy(() -> carsFactory.registerCars(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_CAR_EMPTY.getMessage());
    }

    @Test
    void 자동차_이름_중복_예외처리() {
        assertThatThrownBy(() -> carsFactory.registerCars("a,a,c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_DUPLICATE.getMessage());
    }

}