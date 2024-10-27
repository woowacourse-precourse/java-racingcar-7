package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.exception.ExceptionMessage.CAR_NAME_LENGTH;

class CarImplTest {

    @Test
    @DisplayName("자동차는 이름을 가진다")
    void 자동차_이름_가짐_TEST() {
        String name = "sumin";
        CarImpl car = new CarImpl(name);

        assertThat(car.getCarName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5자 이상 이름", "", "   "})
    @DisplayName("자동차 이름은 1자 이상 5자 이하이다.")
    void 자동차_이름_1자_이상_5자_이하_TEST(final String name) {
        Assertions.assertThatThrownBy(() -> new CarImpl(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH);
    }

    @Test
    @DisplayName("자동차는 4이상의 값을 받으면 전진한다.")
    void 자동차_4이상값_전진_테스트() {
        String name = "테스트이름";
        CarImpl car = new CarImpl(name);

        car.move(1);
        car.move(2);
        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

}