package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class OutputFilterTest {
    @Test
    void testPrintOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // given
        String[] output = {"pobi", "crong", "honux"};

        // when
        OutputFilter.printOutput(OutputFilter.OUTPUT_FILTER, output);


        // then
        assertThat(outputStream.toString()).isEqualTo("최종 우승자: pobi, crong, honux");

    }

    @Test
    void testPrintOutput_우승자_한사람() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // given
        String[] output = {"pobi"};

        // when
        OutputFilter.printOutput(OutputFilter.OUTPUT_FILTER, output);

        // then
        assertThat(outputStream.toString()).isEqualTo("최종 우승자: pobi");
    }

}