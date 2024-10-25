package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static racingcar.exception.Exception.NOT_POSITIVE_NUMBER;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingTest {

    private Car pobi;
    private Car woni;
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        pobi = new Car("pobi", () -> true);
        woni = new Car("woni", () -> false);
        racingCars = new RacingCars(List.of(pobi, woni));
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

    @Test
    void 자동차_레이싱_진행() {
        //given
        Racing racing = new Racing(racingCars, 3);

        //when
        RacingResult racingResult = racing.play();

        //then
        List<String> expectedSnapshot = List.of("pobi : -\nwoni : ", "pobi : --\nwoni : ", "pobi : ---\nwoni : ");
        assertThat(racingResult.getSnapshot()).containsExactlyElementsOf(expectedSnapshot);
        assertThat(racingResult.getWinner()).containsExactly(pobi.getName());
    }
}
