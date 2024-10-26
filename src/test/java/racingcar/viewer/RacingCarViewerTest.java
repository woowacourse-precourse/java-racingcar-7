package racingcar.viewer;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarViewerTest {
    private final RacingCarViewer racingCarViewer = new RacingCarViewer();

    @Test
    @DisplayName("최종 우승자 표시 하는 메서드")
    public void testShowWinners() throws Exception {
        //given
        List<String> winners = Arrays.asList("car1", "car3");
        String expect = "최종 우승자 : car1, car3\n";
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        racingCarViewer.showWinners(winners);

        //then
        Assertions.assertEquals(expect, outputStream.toString());
    }
}