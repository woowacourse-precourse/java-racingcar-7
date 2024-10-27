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

    @DisplayName("출력 테스트")
    @Test
    void test() {
        // Given
        String input = "asd";
        // When
        System.out.println(input);
        String result = getOutput();

        // Then
        assertThat(result).isEqualTo(input);
    }

    private String getOutput() {
        return captor.toString().trim();
    }
}