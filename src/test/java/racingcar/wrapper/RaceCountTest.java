package racingcar.wrapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RaceCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "10000"})
    void 카운트_생성_테스트(String raceCount) {
        RaceCount count = RaceCount.of(raceCount);

        assertThat(count.getRaceCount())
                .isEqualTo(Integer.parseInt(raceCount));
    }

    @ParameterizedTest
    @ValueSource(strings = {"one", "23wooteco", "*@#$*"})
    void 정수_이외_값_예외_테스트(String raceCount) {
        assertThatThrownBy(() -> RaceCount.of(raceCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이스 횟수는 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    void 횟수_0_이하_예외_테스트(String raceCount) {
        assertThatThrownBy(() -> RaceCount.of(raceCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이스 횟수는 1 이상이어야 합니다.");
    }

}
