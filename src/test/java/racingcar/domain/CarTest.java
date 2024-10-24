package racingcar.domain;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.exception.Exception.EMPTY_NAME;
import static racingcar.exception.Exception.INVALID_NAME_LENGTH;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;
    private String carName;

    @BeforeEach
    void setUp() {
        carName = "kyj";
        car = new Car(carName, () -> true);
    }

    @Test
    void 자동차_생성() {
        //given

        //when

        //then
        assertThat(car).hasToString("kyj : ");
    }

    @Test
    void 자동차_전진() {
        //given

        //when
        car.move();

        //then
        assertThat(car).hasToString("kyj : -");
    }

    @Test
    void 자동차_이름_길이_예외() {
        //given

        //when
        Throwable thrown = catchThrowable(() -> new Car("안녕하세요 5자가 넘는 이름이라고 합니다."));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "   "})
    void 자동차_이름_공백_예외(String name) {
        //given

        //when
        Throwable thrown = catchThrowable(() -> new Car(name));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(EMPTY_NAME.getMessage());
    }
}
