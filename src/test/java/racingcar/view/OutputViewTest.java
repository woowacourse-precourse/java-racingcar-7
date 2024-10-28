package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    protected String getOutputBufferToStringByte() {
        return outputStreamCaptor.toString();
    }

    @Test
    void printWinners() {
        // Given: winners
        // When: printWinners 메서드 실행
        OutputView.printWinners(List.of("sumi", "sum"));
        // Then: 형식에 맞게 출력되어야 함.
        assertThat(getOutputBufferToStringByte()).contains("최종 우승자 : sumi, sum");
    }
}