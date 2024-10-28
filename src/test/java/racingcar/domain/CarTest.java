package racingcar.domain;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.exception.Exception.EMPTY_NAME;
import static racingcar.exception.Exception.INVALID_NAME_LENGTH;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;

class CarTest {

    private Car car;
    private String carName;

    @BeforeEach
    void setUp() {
        carName = "kyj";
        car = new Car(carName, () -> true);
    }

    @Test
    void 자동차를_생성한다() {
        //given

        //when

        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    void 자동차를_전진한다() {
        //given

        //when
        car.move();

        //then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    void 자동차_이름의_길이가_5자가_넘으면_예외를_반환한다() {
        //given

        //when
        Throwable thrown = catchThrowable(() -> new Car("안녕하세요 5자가 넘는 이름이라고 합니다."));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "   "})
    void 자동차_이름이_공백이면_예외를_반환한다(String name) {
        //given

        //when
        Throwable thrown = catchThrowable(() -> new Car(name));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(EMPTY_NAME.getMessage());
    }
}
