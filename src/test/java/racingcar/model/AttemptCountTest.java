package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static racingcar.model.AttemptCount.MAX_ATTEMPT_COUNT;
import static racingcar.model.AttemptCount.MIN_ATTEMPT_COUNT;

import org.junit.jupiter.api.Test;

class AttemptCountTest {

    @Test
    void 문자열을_숫자로_타입변경() {
        // given
        String attemptCount = "5";

        // when
        AttemptCount.fromString(attemptCount);

        // then
        assertThat(AttemptCount.fromString(attemptCount).getAttemptCount()).isEqualTo(5);
    }

    @Test
    void 숫자가_아니면_예외() {
        // given
        String attemptCount = "hi";

        // when
        // then
        assertThatThrownBy(() -> AttemptCount.fromString(attemptCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자로만 이루어진 문자열이 아닙니다.");
    }

    @Test
    void 시도_횟수가_정상적인_범위일때() {
        //given
        String attemptCount = "7";

        // when
        // then
        assertThat(AttemptCount.fromString(attemptCount).getAttemptCount()).isEqualTo(7);
    }

    @Test
    void 시도_횟수가_비정상적인_범위일때_예외() {
        //given
        String attemptCountOver = "11";
        String attemptCountUnder = "0";

        // when
        // then
        // when & then (11일 때 예외 발생 확인)
        assertThatThrownBy(() -> AttemptCount.fromString(attemptCountOver))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 " + MIN_ATTEMPT_COUNT + " ~ " + MAX_ATTEMPT_COUNT + "사이여야합니다.");

        assertThatThrownBy(() -> AttemptCount.fromString(attemptCountUnder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 " + MIN_ATTEMPT_COUNT + " ~ " + MAX_ATTEMPT_COUNT + "사이여야합니다.");
    }

    @Test
    void 소수를_입력했을_때_예외() {
        // given
        String attemptCount = "1.5";

        // when
        // then
        assertThatThrownBy(() -> AttemptCount.fromString(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
