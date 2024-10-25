package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class OutputViewTest extends ConsoleOutputTestHelper {

    @Test
    @DisplayName("자동차 이름 입력 프롬포트 출력 테스트")
    void 자동차_이름_입력_프롬포트_테스트() {
        OutputView.printCarNameInputPrompt();

        assertThat(getCapturedOutput().trim())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("시도 횟수 입력 프롬포트 출력 테스트")
    void 시도_횟수_입력_프롬포트_테스트() {
        OutputView.printNumberOfAttemptCountMessage();

        assertThat(getCapturedOutput().trim())
                .isEqualTo("시도할 횟수는 몇 회인가요?");
    }
}