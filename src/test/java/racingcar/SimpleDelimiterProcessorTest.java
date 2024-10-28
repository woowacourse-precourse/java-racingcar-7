package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleDelimiterProcessorTest {

    Processor processor = new SimpleDelimiterProcessor();

    @Test
    void process() {
        String input = "a,b,c";
        assertArrayEquals(processor.process(input), new String[]{"a", "b", "c"});
    }
}