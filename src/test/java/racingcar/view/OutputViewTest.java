package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class OutputViewTest extends ConsoleOutputTestHelper {

    @Test
    @DisplayName("자동차 이름 입력 프롬포트 출력 테스트")
    void 자동차_이름_입력_프롬포트_테스트() {
        OutputView outputView = new OutputView();
        outputView.printCarNameInputPrompt();

        assertThat(getCapturedOutput().trim())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("시도 횟수 입력 프롬포트 출력 테스트")
    void 시도_횟수_입력_프롬포트_테스트() {
        OutputView outputView = new OutputView();
        outputView.printNumberOfAttemptCountMessage();

        assertThat(getCapturedOutput().trim())
                .isEqualTo("시도할 횟수는 몇 회인가요?");
    }

    @Test
    @DisplayName("실행 결과 프롬프트 출력 테스트")
    void 실행_결과_프롬프트_출력_테스트() {
        OutputView outputView = new OutputView();
        outputView.printExecutionResultPrompt();

        assertThat(getCapturedOutput().trim())
                .isEqualTo("실행 결과");
    }

    @Test
    @DisplayName("라운드 진행 상황 출력 테스트")
    void 라운드_진행_상황_출력_테스트() {
        OutputView outputView = new OutputView();
        List<String> formattedProgress = List.of("벤츠 : --", "볼보 : ---", "아우디 : ----");
        outputView.printRoundProgress(formattedProgress);

        assertThat(getCapturedOutput().trim())
                .isEqualTo("벤츠 : --\n볼보 : ---\n아우디 : ----");
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    void 우승자_출력_테스트() {
        OutputView outputView = new OutputView();
        String formattedWinners = "벤츠, 아우디";
        outputView.printWinners(formattedWinners);

        assertThat(getCapturedOutput().trim())
                .isEqualTo("벤츠, 아우디");
    }
}