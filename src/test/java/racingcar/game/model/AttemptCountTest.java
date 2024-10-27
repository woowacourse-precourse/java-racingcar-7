package racingcar.game.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("AttemptCount 를 테스트한다")
class AttemptCountTest {

    @DisplayName("정의된 횟수만큼 동작하면 성공한다.")
    @Test
    void testLoop() {
        // given
        AtomicInteger counter = new AtomicInteger();
        AttemptCount attemptCount = new AttemptCount(5);

        // when
        attemptCount.runUntilConsumed(counter::getAndIncrement);

        // then
        assertThat(counter.get()).isEqualTo(5);
    }
}