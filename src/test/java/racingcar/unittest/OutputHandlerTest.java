package racingcar.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.OutputHandler;

class OutputHandlerTest extends NsTest {

    @Test
    @DisplayName("printStartMessage 메서드 테스트")
    void printStartMessage_shouldPrintCorrectMessage() {
        // When
        OutputHandler.printStartMessage();

        // Then
        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void runMain() {
        // 해당 클래스에서는 runMain을 사용하지 않습니다.
    }
}
