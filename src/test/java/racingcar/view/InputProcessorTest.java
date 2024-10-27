package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputProcessorTest {

    @Test
    void shouldSplitCarNamesByComma() {
        List<String> carNames = InputProcessor.processCarNames("CarA,CarB,CarC");
        assertThat(carNames).containsExactly("CarA", "CarB", "CarC");
    }

    @Test
    void shouldConvertInputToInteger() {
        int attemptCount = InputProcessor.processAttemptCount("5");
        assertThat(attemptCount).isEqualTo(5);
    }
}