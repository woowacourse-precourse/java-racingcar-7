package iohandler;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.Console.readLine;
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
    void 시도할_횟수_입력하기() {
        // given
        Console.close();
        String simulatedInput = "4";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        // when
        int inputRacingCount = inputHandler.getInputRacingCount();

        // then
        assertThat(inputRacingCount).isEqualTo(Integer.parseInt(simulatedInput.trim()));
    }

    @Test
    void 시도할_횟수_양수가_아닌_경우_에러_던지기() {
        // given
        Console.close();
        String simulatedInput = "-1";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        // when // then
        assertThatThrownBy(() -> inputHandler.getInputRacingCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 양수 이여야합니다.");
    }
}