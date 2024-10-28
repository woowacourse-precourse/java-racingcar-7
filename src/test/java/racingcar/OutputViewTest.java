package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.controller.ViewController;
import racingcar.view.OutputView;

class OutputViewTest {

    @Test
    void testPrintOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // given
        List<String> output = List.of("pobi", "crong", "honux");

        // when
        OutputView.printOutput(ViewController.OUTPUT_FILTER, output);

        // then
        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi, crong, honux");
    }

    @Test
    void testPrintOutput_우승자_한사람() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // given
        List<String> output = List.of("pobi");

        // when
        OutputView.printOutput(ViewController.OUTPUT_FILTER, output);

        // then
        assertThat(outputStream.toString().trim()).isEqualTo("최종 우승자 : pobi");
    }
}