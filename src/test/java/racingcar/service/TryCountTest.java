package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.exception.ExceptionMessage.ILLEGAL_TRY_COUNT;

public class TryCountTest {
    @Test
    @DisplayName("TryCount는 음수가 될 수 없다.")
    void validateTryCount_Test() {
        //expected
        Assertions.assertThatThrownBy(() -> new TryCount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_TRY_COUNT.getMessage());
    }

    @Test
    @DisplayName("playOneRount 메소드를 실행하면 tryCount가 1 감소해야한다.")
    void playOneRount_Test() {
        //given
        TryCount tryCount = new TryCount(1);

        //expected
        Assertions.assertThat(tryCount.playOneRound()).isEqualTo(true);
        Assertions.assertThat(tryCount.playOneRound()).isEqualTo(false);
    }
}
