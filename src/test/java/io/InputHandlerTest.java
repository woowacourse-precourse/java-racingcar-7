package io;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest {

    private InputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new InputHandler();
    }

    @Test
    void 차_이름_입력_부분_확인하기() {
        // given
        Console.close();
        String simulatedInput = "pobi,woni,jun";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        // when
        String inputCarName = inputHandler.getInputCarName();

        // then
        assertThat(inputCarName).isEqualTo(simulatedInput.trim());
    }

    @Test
    void 시도할_횟수_입력_부분_확인하기() {
        // given
        Console.close();
        String simulatedInput = "4";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        // when
        String inputRacingCount = inputHandler.getInputRacingCount();

        // then
        assertThat(inputRacingCount).isEqualTo(simulatedInput);
    }
}