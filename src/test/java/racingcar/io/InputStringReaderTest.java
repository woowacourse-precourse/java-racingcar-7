package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputStringReaderTest {

    private void command(String... args) {
        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    public void 자동차_이름을_순서대로_읽을_수_있다() throws Exception {
        //given
        command("pobi,woni,jun");
        InputStringReader inputStringReader = new InputStringReader();

        //when
        String rawCarNames = inputStringReader.readCarNames();

        //then
        assertThat(rawCarNames).contains("pobi", "woni", "jun");
    }
}