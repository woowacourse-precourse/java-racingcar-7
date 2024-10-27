package racingcar.application.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.application.dto.RacingGameRequest;
import racingcar.application.dto.RacingGameResponse;
import racingcar.infrastructure.constant.Boundary;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameServiceTest {
    private static final int MOVING_FORWARD = Boundary.MOVE_CONDITION_MIN;
    private static final int STOP = Boundary.MOVE_CONDITION_MIN - 1;
    private final GameService gameService = new GameService(message -> {});

    @Test
    @DisplayName("올바른 결과를 반환할 수 있다.")
    void 실행_테스트() {
        // given
        final RacingGameRequest request = new RacingGameRequest("우승자, 패배1, 패배2", String.valueOf(1));

        assertRandomNumberInRangeTest(() -> {
            // when
            final RacingGameResponse response = gameService.execute(request);
            // then
            assertThat(response.getValue()).contains("우승자");
        }, MOVING_FORWARD, STOP, STOP);
    }

    @ParameterizedTest
    @DisplayName("실행 횟수로 0 이하의 숫자는 입력할 수 없다.")
    @ValueSource(strings = {"-1", "0"})
    void 음수는_입력할_수_없다(String repeat) {
        // given
        final RacingGameRequest request = new RacingGameRequest("abc", repeat);

        // when & then
        assertThatThrownBy(() -> {
            gameService.execute(request);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행 횟수는 주어진 범위를 초과하면 안된다.")
    void 실행_가능_범위_초과를_확인할_수_있다() {
        // given
        final RacingGameRequest request =
                new RacingGameRequest("abc", String.valueOf(Boundary.REPEAT_MAX + 1));

        // when & then
        assertThatThrownBy(() -> {
            gameService.execute(request);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}