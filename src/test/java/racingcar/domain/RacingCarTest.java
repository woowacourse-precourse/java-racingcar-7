package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}