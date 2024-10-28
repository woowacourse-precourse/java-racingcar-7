package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Round;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoundTest {

    @Test
    @DisplayName("유효한 시도 횟수 입력 시 Round 인스턴스 생성 테스트")
    void createRound_withValidCount() {
        Round round = Round.of("5");
        assertThat(round.hasMoreRounds()).isTrue();
    }

    @Test
    @DisplayName("유효하지 않은 시도 횟수 입력 시 예외 발생")
    void createRound_withInvalidCount_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Round.of("0"));
        assertThrows(IllegalArgumentException.class, () -> Round.of("-1"));
    }
}
