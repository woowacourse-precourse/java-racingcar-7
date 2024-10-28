package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputManagerTest {

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

    @DisplayName("올바른 출력 메시지를 출력한다.")
    @Test
    void Given_When_RoundThen_Success() {
        // Given
        OutputManager.printStartMessage();

        // When
        String message = getOutput();

        // Then
        assertThat(message).isEqualTo("실행 결과");
    }

    private String getOutput() {
        return captor.toString().trim();
    }
}