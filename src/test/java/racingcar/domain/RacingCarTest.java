package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @DisplayName("올바른 자동차 이름으로 RacingCar 객체 생성 테스트")
    @Test
    void givenCorrectName_whenMakeRacingCar_thenReturnRacingCar() throws Exception {
        // given
        String name = "pobi";

        // when
        RacingCar racingCar = new RacingCar(name);

        // then
        assertThat(racingCar).isNotNull();
        assertThat(racingCar.getName()).isEqualTo(name);
    }

    @DisplayName("5글자 초과인 자동차 이름으로 객체 생성 시 예외 테스트")
    @Test
    void givenLongName_whenMakeRacingCar_thenThrowException() throws Exception {
        // given
        String name = "pobipobi";

        // when & then
        assertThatThrownBy(() -> new RacingCar(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차 이름으로 %s는 적절하지 않습니다.", name));
    }

    @DisplayName("자동차가 움직일 수 있을 때 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void givenCanMove_whenIsMove_thenReturnTrue(int randomNum) throws Exception {
        // given
        String name = "test";
        RacingCar racingCar = new RacingCar(name);

        // when & then
        assertTrue(racingCar.isMove(randomNum));
    }

    @DisplayName("자동차가 움직일 수 없을 때 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void givenCanNotMove_whenIsMove_thenReturnFalse(int randomNum) throws Exception {
        // given
        String name = "test";
        RacingCar racingCar = new RacingCar(name);

        // when & then
        assertFalse(racingCar.isMove(randomNum));
    }
}