package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import java.util.List;
import org.junit.jupiter.api.Test;

class ReaderTest {

    public Reader reader = new Reader();

    @Test
    void getNameInput() {
        assertSimpleTest(() -> {

            System.setIn(new java.io.ByteArrayInputStream("pobi,woni,jun\n".getBytes()));
            List<String> result = reader.getNameInput();
            assertThat(result).containsExactly("pobi", "woni", "jun");
        });
    }

    @Test
    void getTryInput() {
        assertSimpleTest(() -> {
            System.setIn(new java.io.ByteArrayInputStream("2\n".getBytes()));
            int result = reader.getTryInput();
            assertThat(result).isEqualTo(2);
        });
    }
}