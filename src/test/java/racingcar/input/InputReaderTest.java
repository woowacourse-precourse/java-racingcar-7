package racingcar.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputReaderTest {

    private InputReader inputReader;

    @BeforeEach
    void setUp() {
        inputReader = new InputReader(new InputParser());
    }

    private void setInput(String value) {
        System.setIn(new ByteArrayInputStream(value.getBytes()));
    }

    @Test
    void 자동차_이름_입력값_반환() {
        setInput("pobi,woni");

        List<String> cars = inputReader.getNames();

        assertEquals(cars.size(), 2);
        assertEquals(cars.get(0), "pobi");
        assertEquals(cars.get(1), "woni");
    }

    @Test
    void 시도할_횟수_입력값_반환() {
        setInput("1");
        assertEquals(inputReader.getTryCnt(), 1);
    }

    @Test
    void 이름_입력값이_공백인_경우() {
        setInput(" ");
        assertThatThrownBy(() -> inputReader.getNames())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_횟수가_0인_경우() {
        setInput("0");
        assertThatThrownBy(() -> inputReader.getTryCnt())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_횟수가_숫자가_아닌_경우() {
        setInput("abc");
        assertThatThrownBy(() -> inputReader.getTryCnt())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_횟수가_숫자와_영문이_혼합된_경우() {
        setInput("12abc");
        assertThatThrownBy(() -> inputReader.getTryCnt())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
