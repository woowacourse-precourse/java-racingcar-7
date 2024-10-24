package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InputProcessorTest {

    @Test
    void 자동차_이름은_구분자로_구분하여_차_객체로_변환한다() {
        String input = "pobi,woni,jun";

        List<Car> cars = InputProcessor.parseToCarNameList(input);

        assertThat(cars)
                .extracting(Car::getCarName)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 시도_횟수가_정수로_변환된다() {
        String attemptCountInput = "5";

        int attemptCount = InputProcessor.parseToAttemptCount(attemptCountInput);

        assertThat(attemptCount).isEqualTo(5);
    }
}
