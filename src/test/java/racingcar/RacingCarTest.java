package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"다섯글자이상", "포르쉐카이엔"})
    public void registWithOverLength(String racingCarName) throws Exception {
        //given

        //when, then
        assertThatThrownBy(() -> {
            RacingCar newRacingCar = new RacingCar(racingCarName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}