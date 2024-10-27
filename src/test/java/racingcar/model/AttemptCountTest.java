package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AttemptCountTest {

    @Test
    void 시도횟수_감소_테스트(){
        AttemptCount attemptCount = AttemptCount.from(3);

        attemptCount.decrease();

        assertThat(attemptCount.getCount()).isEqualTo(2);
    }

    @Test
    void 시도횟수_감소_실패_테스트(){
        AttemptCount attemptCount = AttemptCount.from(1);

        attemptCount.decrease();

        assertThatThrownBy(() -> attemptCount.decrease())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_가능_여부_판별_테스트(){
        AttemptCount attemptCount = AttemptCount.from(1);

        assertThat(attemptCount.canRace()).isTrue();
        attemptCount.decrease();
        assertThat(attemptCount.canRace()).isFalse();
    }

}
