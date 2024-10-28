package racingcar.controller;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.mock.TestGameService;
import racingcar.mock.TestInputView;
import racingcar.mock.TestOutputView;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

@DisplayName("게임 컨트롤러(GameController) 유스케이스")
class GameControllerTest {

    @DisplayName("게임 시작하기")
    @Nested
    class 게임_시작하기 {

        @DisplayName("정상적인 게임 시작")
        @Test
        void 정상적인_게임_시작() {
            // given
            GameService gameService = new TestGameService();
            InputView inputView = new TestInputView(List.of("p1", "p2"), 2);
            OutputView outputView = new TestOutputView();
            GameController gameController = new GameController(gameService, inputView, outputView);

            // expect
            Assertions.assertThatCode(() -> gameController.start())
                    .doesNotThrowAnyException();
        }

    }

}