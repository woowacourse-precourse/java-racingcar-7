package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;
import racingcar.view.TestInputView;

import static org.assertj.core.api.Assertions.*;

@DisplayName("GameController 테스트")
public class GameControllerTest {
    @Test
    void 자동차_이름_중복_예외_테스트() {
        TestInputView testInputView = new TestInputView();
        testInputView.setCarNames(new String[]{"pobi", "crong", "pobi"});
        testInputView.setTryCount(5);
        GameController gameController = new GameController(testInputView);

        assertThatThrownBy(gameController::run)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 자동차_수_검증_예외_테스트() {
        TestInputView testInputView = new TestInputView();
        testInputView.setCarNames(new String[]{});
        testInputView.setTryCount(5);
        GameController gameController = new GameController(testInputView);

        assertThatThrownBy(gameController::run)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 최소 1대 이상이어야 합니다.");
    }

    @Test
    void 시도_횟수_음수_예외_테스트() {
        TestInputView testInputView = new TestInputView();
        testInputView.setCarNames(new String[]{"pobi", "crong"});
        testInputView.setTryCount(-1);
        GameController gameController = new GameController(testInputView);

        assertThatThrownBy(gameController::run)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }
}
