package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputTest {
    @Test
    void shouldReturnWordCountsWhenInputSplitCarNames() {
        Input input = new Input("alpha,beta,delta", "1");
        String[] carNames = input.splitCarNameInput();
        assertThat(carNames)
                .isNotEmpty()
                .contains("alpha")
                .contains("beta")
                .contains("delta")
                .hasSize(3);
    }
}

