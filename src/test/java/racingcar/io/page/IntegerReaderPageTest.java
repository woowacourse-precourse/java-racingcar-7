package racingcar.io.page;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class IntegerReaderPageTest extends NsTest {

    @Override
    protected void runMain() {}

    @Test
    void read_and_getOutput_should_be_pass() {
        // given
        String content = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        ReaderPage<String, Integer> page = new IntegerReaderPage();
        // when
        // then
        assertThat(output()).isEqualTo(page.getContent());
        assertThat(page.getReader()).isEqualTo(page.getReader());
        assertSimpleTest(() -> {
            String in = "10";
            run(in + "\n");
            page.render();
            int output = page.getOutput();
            assertThat(content + output).isEqualTo(content + in);
        });
    }
}
