package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class InputManagerTest {
    private final InputStream originalIn = System.in;

    @AfterEach
    void restoreSystemIn() {
        System.setIn(originalIn);
    }

    @Test
    void 자동차이름과횟수_입력_테스트() {
        String input = "obi,woni,nunu\n3";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        InputManager inputManager = new InputManager();
        inputManager.processInput();

        ArrayList<Car> cars = inputManager.getCars();
        String[] expectedNames = {"obi", "woni", "nunu"};

        for (int i = 0; i < expectedNames.length; i++) {
            assertThat(cars.get(i).getName()).isEqualTo(expectedNames[i]);
        }

        assertThat(inputManager.getNumber()).isEqualTo(3);
    }
}
