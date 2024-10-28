package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCountsTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "-8"})
    void 영_이하_입력시_예외_발생(String gameCounts) {
        assertThatThrownBy(() -> new GameCounts(gameCounts)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("게임은 한 번 이상 실행되어야 합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1j", "skjfk"})
    void 숫자를_입력하지_않았을때_예외_발생(String gameCounts) {
        assertThatThrownBy(() -> new GameCounts(gameCounts)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("게임은 양수인 정수 범위에서 실행되어야 합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "+3", "2"})
    void 정상_작동_확인(String gameCounts) {
        assertThat(new GameCounts(gameCounts)).usingRecursiveComparison().isEqualTo(new GameCounts(gameCounts));
    }
}




