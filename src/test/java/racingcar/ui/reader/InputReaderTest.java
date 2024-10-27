package racingcar.ui.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ui.mock.DummyStringPrinter;
import racingcar.ui.mock.StubStringReader;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class InputReaderTest {

    private InputReader reader;
    private StubStringReader stubReader;
    private DummyStringPrinter dummyPrinter;

    @BeforeEach
    void beforeEach() {
        stubReader = new StubStringReader();
        dummyPrinter = new DummyStringPrinter();
        reader = new InputReader(stubReader, dummyPrinter);
    }


    @Test
    @DisplayName("이름을 읽어옴")
    void test1() {
        String names = "pobi,woni,jun";
        stubReader.setMockUserInput(names);

        List<String> result = reader.readNames();

        assertThat(result).isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @Test
    @DisplayName("이름 길이가 5를 초과하면 예외를 발생")
    void test2() {
        String names = "pobi,abcdef,jun";
        stubReader.setMockUserInput(names);

        assertThrows(IllegalArgumentException.class, () -> reader.readNames());
    }

}
