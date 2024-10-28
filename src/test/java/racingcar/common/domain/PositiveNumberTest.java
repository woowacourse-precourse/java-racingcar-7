package racingcar.common.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameplayer.game.common.domain.PositiveNumber;

class PositiveNumberTest {

    @Test
    @DisplayName("값이 0보다 작다면 예외가 발생한다")
    void positiveNumberMustBiggerThan0() {
        assertThatThrownBy(() -> new PositiveNumber(-1L))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("값이 0이면 정상적으로 생성된다")
    void positiveNumberWith0MustsBeCreated() {
        assertThatCode(() -> new PositiveNumber(0L))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("값이 0보다 크면 정상적으로 생성된다")
    void positiveNumberBiggerThan0MustsBeCreated() {
        assertThatCode(() -> new PositiveNumber(100L))
            .doesNotThrowAnyException();
    }
}