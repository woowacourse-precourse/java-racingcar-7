package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.utils.CustomErrorMessage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

    @Test
    void getCarName_유효한_입력() {
        String simulatedInput = "pobi,java\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        Input input = new Input();
        List<String> carNames = input.getCarName();

        assertThat(carNames).containsExactly("pobi", "java");
    }

    @Test
    void getCarName_5자를_초과하는_입력() {
        String simulatedInput = "pobi,javajava\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Input input = new Input();

        assertThatThrownBy(input::getCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CustomErrorMessage.INVALID_CAR_NAME);
    }

    @Test
    void getRound_유효한_숫자_입력() {
        String simulatedInput = "5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Input input = new Input();
        int round = input.getRound();

        assertThat(round).isEqualTo(5);
    }

    @Test
    void getRound_유효하지_않은_숫자_입력() {
        String simulatedInput = "0\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Input input = new Input();

        assertThatThrownBy(input::getRound)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CustomErrorMessage.INVALID_ROUND);
    }
}
