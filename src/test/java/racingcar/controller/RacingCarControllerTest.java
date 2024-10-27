package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarControllerTest {
    private RacingCarController racingCarController;

    private static class TestInputView extends InputView {
        @Override
        public String readCarNames() {
            return "pobi, woni, sall";
        }

        @Override
        public String readTryCounts() {
            return "5";
        }
    }

    @BeforeEach
    void setUp() {
        racingCarController = new RacingCarController(new RacingCarService(), new TestInputView(), new OutputView());
    }

    @Test
    @DisplayName("startGame 메소드 실행 시 RacingCarController가 정상적으로 작동해야한다.")
    void startGame_Test() {
        assertThatCode(()-> racingCarController.startGame())
                .doesNotThrowAnyException();
    }
}
