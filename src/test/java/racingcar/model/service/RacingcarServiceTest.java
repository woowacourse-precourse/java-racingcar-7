package racingcar.model.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.GameEnvironment;

class RacingcarServiceTest {

    private GameEnvironment gameEnvironment;
    private RacingcarService racingcarService;

    @BeforeEach
    void setUp() {
        gameEnvironment = new GameEnvironment();
        racingcarService = new RacingcarService(gameEnvironment);
    }

    @Test
    void 자동차_저장_성공_테스트() {
        // given
        String carNamesInput = "pobi,crong,honux";

        // when
        int result = racingcarService.saveCars(carNamesInput);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 시도횟수_저장_성공_테스트() {
        // given
        String attemptCountInput = "5";

        // when
        int result = racingcarService.saveAttemptCount(attemptCountInput);

        // then
        assertThat(result).isEqualTo(1);
        assertThat(gameEnvironment.getAttemptCount()).isEqualTo(5);
    }

    @Test
    void 구분자_없는_자동차_저장_실패_테스트() {
        // given
        String carNamesInput = "pobi crong honux";

        // when & then
        assertThatThrownBy(() -> racingcarService.saveCars(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 쉼표(,)로 구분되어야 합니다.");
    }

    @Test
    void 자동차_이름_길이_5_초과_실패_테스트() {
        // given
        String carNamesInput = "pobi123,crong,honux";

        // when & then
        assertThatThrownBy(() -> racingcarService.saveCars(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하이어야 합니다");
    }

    @Test
    void 시도횟수_숫자_변환_실패_테스트() {
        // given
        String attemptCountInput = "five";

        // when & then
        assertThatThrownBy(() -> racingcarService.saveAttemptCount(attemptCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자여야 합니다.");
    }

    @Test
    void 시도횟수_1_미만_실패_테스트() {
        // given
        String attemptCountInput = "0";

        // when & then
        assertThatThrownBy(() -> racingcarService.saveAttemptCount(attemptCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 시도횟수_Integer_최대값_초과_실패_테스트() {
        // given
        String attemptCountInput = "2147483648"; // Integer.MAX_VALUE + 1

        // when & then
        assertThatThrownBy(() -> racingcarService.saveAttemptCount(attemptCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 " + Integer.MAX_VALUE + " 이하이어야 합니다.");
    }
}
