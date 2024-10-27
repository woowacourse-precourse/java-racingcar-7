package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputDataTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 자동차입력_출력_확인_테스트() {
        // given
        String input = "pobi,java\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        String result = InputData.getInputData();

        // then
        String expectedOutput = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        String actualOutput = outputStreamCaptor.toString().trim();

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}