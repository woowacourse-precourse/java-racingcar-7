package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputCountTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 시도횟수_출력_확인_테스트() {
        // given
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        String result = InputCount.getInputCountData();

        // then
        String expectedOutput = "시도할 횟수는 몇 회인가요?";
        String actualOutput = outputStreamCaptor.toString().trim();

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}