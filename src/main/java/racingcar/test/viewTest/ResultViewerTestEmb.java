package racingcar.test.viewTest;

import org.junit.jupiter.api.Test;
import racingcar.view.ResultViewer;
import racingcar.view.ResultViewerEmb;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewerTestEmb implements ResultViewerTest {
    @Test
    public void testOutput() {
        ResultViewer resultViewer = new ResultViewerEmb();
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        resultViewer.output("check");
        String output = outputStream.toString();
        assertThat(output).contains("check");
    }
}
