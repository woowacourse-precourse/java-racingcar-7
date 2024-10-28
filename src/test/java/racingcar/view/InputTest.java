package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.utils.CustomErrorMessage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputTest {

    private void provideInput(String data) {
        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
    }


    @Test
    void getCarName_5자를_초과하는_입력() {
        provideInput("pobi,javajava\n");
        Input input = new Input();
        assertThatThrownBy(input::getCarName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CustomErrorMessage.INVALID_CAR_NAME);
    }

}
