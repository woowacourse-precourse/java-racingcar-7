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
                .hasMessageContaining("자동차 이름은 5자 이하이어야 합니다.");
    }

    @Test
    void 자동차_이름_공백_포함_실패_테스트() {
        // given
        String carNamesInput = "pobi,,crong,honux";

        // when & then
        assertThatThrownBy(() -> racingcarService.saveCars(carNamesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백일 수 없습니다.");
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
    void 시도횟수_최대값_초과_실패_테스트() {
        // given
        String attemptCountInput = "10001";

        // when & then
        assertThatThrownBy(() -> racingcarService.saveAttemptCount(attemptCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 " + 10000 + " 이하이어야 합니다.");
    }
}
