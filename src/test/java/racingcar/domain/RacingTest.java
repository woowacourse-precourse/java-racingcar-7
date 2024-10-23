package racingcar.domain;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.exception.Exception.NOT_POSITIVE_NUMBER;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingTest {

    private List<String> carNames;
    private Racing racing;

    @BeforeEach
    void setUp() {
        carNames = List.of("pobi", "woni");
        int tryCount = 2;
        racing = Racing.of(carNames, tryCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 레이싱_시도_횟수_예외(int tryCount) {
        //given

        //when
        Throwable thrown = catchThrowable(() -> Racing.of(carNames, tryCount));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_POSITIVE_NUMBER.getMessage());
    }
}
