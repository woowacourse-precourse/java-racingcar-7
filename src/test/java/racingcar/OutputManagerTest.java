package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputManagerTest {

    private static final String GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void rollback() {
        System.setOut(standardOut);
    }

    @DisplayName("사용자에게 가이드 메시지를 출력해야 한다.")
    @Test
    public void printGuidMessage() {

        //given
        OutputManager.printGuideMessage();

        //when
        String printMessage = getOutput();

        //then
        assertThat(printMessage).isEqualTo(GUIDE_MESSAGE);
    }

    private String getOutput() {
        return captor.toString().trim();
    }

}