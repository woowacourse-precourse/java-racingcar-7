package racingcar.model.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constants.ErrorMessage.NOT_ALLOWED_CAR_NAME_LENGTH;

class CarTest {
    private Car movableCar;
    private Car immovableCar;

    @BeforeEach
    void setUp() {
        movableCar = new Car("name") {
            @Override
            public int pickRandomNumber() {
                return 4;
            }
        };


        immovableCar = new Car("name") {
            @Override
            public int pickRandomNumber() {
                return 3;
            }
        };
    }

    @Test
    void 자동차_이름이_6자_이상이면_예외가_발생한다() {
        // given
        String name = "abcdef";

        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_CAR_NAME_LENGTH);
    }

    @Test
    void 랜덤_값이_4_이상인_경우_전진에_성공한다() {
        // given
        int expected = 1;

        // when
        movableCar.tryForward();
        int real = movableCar.positionToString().length();

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void 랜덤_값이_4_미만인_경우_전진에_실패한다() {
        // given
        int expected = 0;

        // when
        immovableCar.tryForward();
        int real = immovableCar.positionToString().length();

        // then
        assertThat(real).isEqualTo(expected);
    }
}