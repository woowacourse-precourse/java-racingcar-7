package racingcar.io.page;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class SimpleTextReaderPageTest extends NsTest {

    @Override
    protected void runMain() {}

    @Test
    void read_and_getOutput_test() {
        // given
        String content = "시도할 횟수는 몇 회인가요?";
        ReaderPage<String, String> page = new SimpleTextReaderPage(content);
        // when
        // then
        assertThat(content).isEqualTo(page.getContent());
        assertThat(page.getReader()).isEqualTo(page.getReader());
        assertSimpleTest(() -> {
            String input = "5";
            run(input + "\n");
            page.render();
            String output = page.getOutput();
            assertThat(content + output).isEqualTo(content + input);
        });
    }

}
