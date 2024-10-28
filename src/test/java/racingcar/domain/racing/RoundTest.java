package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundTest {

    @DisplayName("라운드는 1 이상 100 이하 진행 가능하다")
    @ValueSource(ints = {1, 100})
    @ParameterizedTest
    void 라운드_생성_성공(int total) {
        assertDoesNotThrow(() -> Round.create(total));
    }

    @DisplayName("라운드는 1 미만, 100 초과 진행 불가능하다")
    @ValueSource(ints = {0, 101})
    @ParameterizedTest
    void 라운드_생성_실패(int total) {
        assertThatThrownBy(() -> Round.create(total))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 경주는 1 이상 100 이하의 라운드만 진행 가능합니다.");
    }

}
