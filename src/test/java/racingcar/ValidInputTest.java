package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.UserInputDTO;
import racingcar.util.InputParser;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidInputTest {

    private static String nameInput;
    private static String numOfStages;

    @BeforeEach
    void setUp() {
        nameInput = "a,b,c";
        numOfStages = "3";
    }

    @Test
    void 자동차_이름은_5글자를_넘어선_안_된다() {
        nameInput = "bmw, genesis, maserati";
        UserInputDTO userInput = new UserInputDTO(nameInput, Long.parseLong(numOfStages));

        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.getCarList(userInput);
        });
    }

    @Test
    void 자동차_이름을_입력해야_한다() {
        nameInput = ",,,";
        UserInputDTO userInput = new UserInputDTO(nameInput, Long.parseLong(numOfStages));

        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.getCarList(userInput);
        });
    }

    @Test
    void 시도_횟수는_양의_숫자여야_한다() {
        numOfStages = "-3";
        setSystemInput();

        assertThrows(IllegalArgumentException.class, InputView::getUserInput);
    }

    @Test
    void 시도_횟수는_Long타입의_범위를_벗어나선_안_된다() {
        numOfStages = "9999999999999999999";
        setSystemInput();

        assertThrows(IllegalArgumentException.class, InputView::getUserInput);
    }

    private void setSystemInput() {
        System.setIn(new ByteArrayInputStream((nameInput + "\n" + numOfStages).getBytes()));
    }

    @AfterEach
    void tearDown() {
        nameInput = "";
        numOfStages = "";
    }
}
