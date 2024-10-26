package racingcar.domain.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoundExecutorTest {

    @DisplayName("최소 라운드보다 작거나 최대 라운드보다 크게 RoundExecutor를 생성하면 예외가 발생한다.")
    @CsvSource({"0", "101"})
    @ParameterizedTest
    void newRoundExecutorMinMaxRoundThrowException(int round) {
        //when //then
        assertThatThrownBy(() -> new RoundExecutor(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상 100 이하여야 합니다.");
    }

    @DisplayName("지정된 라운드 만큼 Runnable을 호출한다.")
    @Test
    void executeAllRound() {
        //given
        RoundExecutor roundExecutor = new RoundExecutor(3);
        StringBuilder sb = new StringBuilder();
        Runnable runnable = () -> sb.append("a");

        //when
        roundExecutor.executeAllRound(runnable);

        //then
        assertThat(sb.toString()).isEqualTo("aaa");
    }

}