package racingcar.io.read;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class IntegerReaderTest extends NsTest {

    @Override
    protected void runMain() {}

    @Test
    void read_should_be_pass() {
        // given
        String in = "1234";
        // when
        IntegerReader reader = new IntegerReader();
        // then
        assertSimpleTest(() -> {
            run(in+"\n");
            Integer read = reader.read();
            assertThat(read).isEqualTo(1234);
        });
    }

    @Test
    void read_given_nan_should_be_fail() {
        // given
        String in = "nan";
        // when
        IntegerReader reader = new IntegerReader();
        // then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                runException(in + "\n");
                reader.read();
            }).isInstanceOf(IllegalArgumentException.class).hasMessage("숫자를 입력해주세요.");
        });
    }
}
