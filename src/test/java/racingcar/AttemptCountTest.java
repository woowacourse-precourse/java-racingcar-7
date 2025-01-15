package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptCountTest {

    @DisplayName("시도횟수가 정상적일 경우 int를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"10000", "1", "999"})
    void attemptCountTest1(String inputCount) {
        // given & when
        int attemptCount = AttemptCount.from(inputCount);

        // then
        Assertions.assertThat(attemptCount).isEqualTo(Integer.parseInt(inputCount));
    }

    @DisplayName("시도횟수가 정상적이지 않을 경우 에러를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "abc", " ", "", "3333333333333333"})
    void attemptCountTest2(String inputCount) {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            AttemptCount.from(inputCount);
        });
    }
}
