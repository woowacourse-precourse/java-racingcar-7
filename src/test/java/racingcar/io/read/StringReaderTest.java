package racingcar.io.read;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class StringReaderTest extends NsTest {

    @Override
    protected void runMain() {}

    @Test
    void read_test() {
        // given
        String input = "this is input value";
        // when
        StringReader reader = new StringReader();
        // then
        assertSimpleTest(() -> {
            run(input+"\n");
            String read = reader.read();
            assertThat(read).isEqualTo(input);
        });
    }

}
