package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class ReaderTest {

    public Reader reader = new Reader();

    @Test
    void inputTest() {
        assertSimpleTest(() -> {
            command("pobi,woni,jun", "2");
            List<String> nameResult = reader.getNameInput();
            int tryResult = reader.getTryInput();

            assertThat(nameResult).containsExactly("pobi", "woni", "jun");
            assertThat(tryResult).isEqualTo(2);
        });
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}