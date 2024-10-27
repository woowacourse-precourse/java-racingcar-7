package racingcar.test.controllerIOTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.IO.InputController;
import racingcar.controller.IO.InputControllerEmb;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputControllerTestEmb implements InputControllerTest {
    @Test
    public void run(){
        InputController inputController = new InputControllerEmb();
        String carNamesInput = "a,b,c";
        String roundsInput = "5";
        InputStream inputStream = new ByteArrayInputStream((carNamesInput + "\n" + roundsInput).getBytes());
        System.setIn(inputStream);
        List<String> cars = inputController.getCarsInput();
        assertThat(cars).isNotEmpty();
        assertThat(inputController.getRoundInput()).isGreaterThan(0);
    }
}
