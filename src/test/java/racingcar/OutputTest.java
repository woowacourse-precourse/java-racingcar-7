package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest extends NsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent)); // System.out을 ByteArrayOutputStream으로 리다이렉트
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut); // System.out을 원래대로 복구
    }

    /** 테스트 클래스 명 -> [메서드 명]_[테스트 중 상태]_[기대 행위] **/
    @Test
    @DisplayName("경주할 자동차 이름 입력 요청 메세지 출력")
    void printCarNameRequestMessage_MethodCall_ShouldPrintCarNameRequestMessage() {
        //when
        Output.printCarNameRequestMessage();

        //then
        assertThat(outContent.toString().trim())
                .isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        outContent.reset(); // 매 테스트 후 출력 리셋
    }

    @Test
    @DisplayName("시도할 횟수 입력 요청 메세지 출력")
    void printNumberRequestMessage_MethodCall_ShouldPrintNumberRequestMessage() {
        //when
        Output.printNumberRequestMessage();

        //then
        assertThat(outContent.toString().trim())
                .isEqualTo("시도할 횟수는 몇 회인가요?");
        outContent.reset(); // 매 테스트 후 출력 리셋
    }
}
