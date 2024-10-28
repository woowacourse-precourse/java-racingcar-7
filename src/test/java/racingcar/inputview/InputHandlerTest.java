package racingcar.inputview;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {
private InputHandler inputHandler;

    @BeforeEach
    public void setUp(){
        inputHandler = new InputHandler();
    }


    @Test
    void split() {
        String input = "do,rae,mi";

        assertThat(inputHandler.split(input)).isEqualTo(new String[]{"do", "rae", "mi"});
    }

    @Test
    void splitException() {
        String inputNothing = "";
        String inputBlank = " ";
        String inputWrongFormat = "sonata,avante";

        assertThrows(IllegalArgumentException.class, () -> inputHandler.split(inputNothing));
        assertThrows(IllegalArgumentException.class, () -> inputHandler.split(inputBlank));
        assertThrows(IllegalArgumentException.class, () -> inputHandler.split(inputWrongFormat));
    }




    @Test
    void getAttemptGameCount() {
        String inputNothing = "";
        String inputZero = "0";

        assertThrows(IllegalArgumentException.class, () -> inputHandler.getAttemptGameCount(inputNothing));
        assertThrows(IllegalArgumentException.class, () -> inputHandler.getAttemptGameCount(inputZero));
    }
}