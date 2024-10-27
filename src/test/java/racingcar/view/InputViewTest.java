package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    void getInputName() {
        String input = "car1,car2,car3\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String inputName = inputView.getInputName();

        assertEquals("car1,car2,car3", inputName);
    }

    @Test
    void getInputTimes() {
        String input = "5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int inputTimes = inputView.getInputTimes();

        assertEquals(5, inputTimes);
    }
}
