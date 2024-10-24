package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @Test
    void 최대_위치와_같으면_TRUE를_반환한다() {
        //given
        RacingCar racingCar = new RacingCar("준수", 4);

        //when
        int maxPosition = 4;
        boolean actual = racingCar.isWinner(maxPosition);

        //then
        assertTrue(actual);
    }

    @Test
    void 최대_위치와_다르면_FALSE를_반환한다() {
        //given
        RacingCar racingCar = new RacingCar("준수", 4);

        //when
        int maxPosition = 5;
        boolean actual = racingCar.isWinner(maxPosition);

        //then
        assertFalse(actual);
    }

    @Test
    void 레이싱카는_한_칸씩_움직인다() {
        //given
        int position = 0;
        RacingCar racingCar = new RacingCar("준수", position);

        //when
        racingCar.move();

        //then
        assertThat(racingCar.getPosition()).isEqualTo(position + 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void 레이상카의_이름은_1에서_5_글자_사이이다(String name) {
        assertDoesNotThrow(() -> RacingCar.from(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void 레이상카의_옳지_않은_이름_길이는_예외가_발생한다(String name) {
        assertThatThrownBy(() -> RacingCar.from(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 1~5글자입니다.");
    }

}