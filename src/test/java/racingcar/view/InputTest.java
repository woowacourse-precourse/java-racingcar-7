package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputTest extends NsTest {
    @Test
    void 자동차_이름은_쉼표를_기준으로_구분한다() {
        String input = "김종경,김철수,김기명\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> result = new Input().readCarName();

        assertEquals(List.of("김종경", "김철수", "김기명"), result);
    }

    @Override
    protected void runMain() {

    }
}
