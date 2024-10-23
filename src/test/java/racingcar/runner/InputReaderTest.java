package racingcar.runner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputReaderTest {

    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        this.captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(this.captor));
    }

    @DisplayName("[정상] 숫자 입력 호출")
    @Test
    void getInteger() {
        // given
        InputReader reader = new InputReader(1);
        // when
        this.command("3");
        // then
        assertEquals(3, reader.getIntegerWithQuestion("question"));
        assertThat(output()).contains("question");
    }

    @DisplayName("[예외] 숫자 입력 호출 (숫자가 아닌 경우)")
    @Test
    void getIntegerException() {
        // given
        InputReader reader = new InputReader(1);
        // when
        this.command("a");
        // then
        assertThrows(IllegalArgumentException.class, () -> reader.getIntegerWithQuestion("question"));
        assertThat(output()).contains("question");
    }

    @DisplayName("[정상] 문자열 입력 호출")
    @Test
    void getString() {
        // given
        InputReader reader = new InputReader(1);
        // when
        this.command("input");
        // then
        assertEquals("input", reader.getStringWithQuestion("question"));
        assertThat(output()).contains("question");
    }

    @DisplayName("[예외] 호출 횟수가 넘은 경우")
    @Test
    void overTotalReadCnt() {
        // given
        InputReader reader = new InputReader(1);
        // when
        this.command("a", "b");
        System.out.println(reader.get());
        assertThat(output()).contains("a");
        // then
        assertThrows(IllegalArgumentException.class, reader::get);
    }

    private void command(String... args) {
        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    protected final String output() {
        return this.captor.toString().trim();
    }
}