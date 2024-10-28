package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceControllerTest {
    private RaceController raceController;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        // System.out의 출력을 캡처하기 위한 스트림 설정
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // TestConsoleReader를 사용하여 입력값 설정
        raceController = new RaceController(new TestConsoleReader("Car1,Car2", "5"));
    }

    @Test
    public void testStartRace() {
        // When
        raceController.startRace();

        // Then
        assertEquals(2, raceController.getRace().getCarsStatus().size());
        assertEquals(5, raceController.getRace().getMoveCount());
    }

    @Test
    public void testExecuteRace() {
        // Given
        raceController.startRace();

        // When
        raceController.executeRace();

        // Then
        assertEquals(5, raceController.getRace().getMoveCount());
    }

    @Test
    public void testEndRace() {
        // Given
        raceController.startRace();
        raceController.executeRace();

        // When
        raceController.endRace();

        // Then
        String actualOutput = outputStream.toString().trim(); // 캡처된 출력값
        assertTrue(actualOutput.contains("최종 우승자 :")); // "최종 우승자 :"가 포함되는지만 확인
    }

    private static class TestConsoleReader implements ConsoleReader {
        private final String[] inputs;
        private int index = 0;

        public TestConsoleReader(String... inputs) {
            this.inputs = inputs;
        }

        @Override
        public String readLine() {
            return inputs[index++];
        }
    }
}
