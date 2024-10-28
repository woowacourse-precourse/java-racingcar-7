package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingCarController;
import racingcar.service.AcceleratorService;
import racingcar.service.impl.RandomNumberGeneratorService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarControllerIntegrationTest {

    private RacingCarController controller;
    private TestInputView inputView;
    private TestOutputView outputView;
    private AcceleratorService acceleratorService;

    @BeforeEach
    void setUp() {
        inputView = new TestInputView();
        outputView = new TestOutputView();
        acceleratorService = new AcceleratorService(new RandomNumberGeneratorService());
        controller = new RacingCarController(acceleratorService, inputView, outputView);
    }

    @Test
    @DisplayName("게임 실행 및 최종 우승자 출력 테스트")
    void runGameTest() {
        // 실행
        controller.run();

        // 결과 검증
        assertThat(outputView.executionMessages)
                .contains("실행 결과");

        // 라운드별 결과 출력 확인
        assertThat(outputView.roundResults)
                .isNotEmpty()
                .allMatch(result -> result.contains(":"));

        // 최종 우승자 출력 확인
        assertThat(outputView.finalWinnerMessage)
                .contains("최종 우승자");
    }

    // 테스트용 InputView 구현
    static class TestInputView implements InputView {
        @Override
        public String readCarNames() {
            return "car1,car2,car3";
        }

        @Override
        public String readRound() {
            return "5";
        }
    }

    // 테스트용 OutputView 구현
    static class TestOutputView implements OutputView {
        List<String> executionMessages = new ArrayList<>();
        List<String> roundResults = new ArrayList<>();
        String finalWinnerMessage;

        @Override
        public void printExecutionMessage() {
            executionMessages.add("실행 결과");
        }

        @Override
        public void printResult(racingcar.dto.Result result) {
            roundResults.add(result.middleResult());
        }

        @Override
        public void printFinalWinner(String finalWinner) {
            this.finalWinnerMessage = finalWinner;
        }
    }
}
