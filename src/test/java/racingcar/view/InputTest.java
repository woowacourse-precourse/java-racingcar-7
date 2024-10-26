package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class InputTest extends NsTest {
    @Test
    void 자동차_이름은_쉼표를_기준으로_구분한다() {
        String input = "김종경,김철수,김기명\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> result = new Input().readCarName();

        assertEquals(List.of("김종경", "김철수", "김기명"), result);
    }

    @Test
    void 시도할_횟수를_입력할_수_있어야_한다() {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = new Input().readTryNumber();

        assertEquals(5, result);
    }

    @Override
    protected void runMain() {

    }
}
