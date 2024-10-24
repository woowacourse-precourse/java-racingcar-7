package racingcar.domain;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.exception.Exception.NOT_POSITIVE_NUMBER;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("pobi", "woni");
        racingCars = RacingCars.of(carNames);
        int tryCount = 2;
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 레이싱_시도_횟수_예외(int tryCount) {
        //given

        //when
        Throwable thrown = catchThrowable(() -> new Racing(racingCars, tryCount));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_POSITIVE_NUMBER.getMessage());
    }
}
