package racingcar.test.viewTest;

import org.junit.jupiter.api.Test;
import racingcar.view.InputHandler;
import racingcar.view.InputHandlerEmb;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTestEmb implements InputHandlerTest {
    @Test
    @Override
    public void testGetInput(){
        InputHandler inputHandler = new InputHandlerEmb();
        String input = "sample input";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThat(input).isEqualTo("sample input");
        System.setIn(System.in);
    }
}
