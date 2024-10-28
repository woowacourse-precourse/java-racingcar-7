package racingcar.iohandler;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest {

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @DisplayName("차 이름 입력 시 해당 이름들로 배열을 만들어 반환한다.")
    @Test
    void getCarNamesFromUser() {

        String input = "apple,banana\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputHandler inputHandler = new InputHandler();
        String[] carNamesFromUser = inputHandler.getCarNamesFromUser();

        assertThat(carNamesFromUser).isNotEmpty();
        assertThat(carNamesFromUser).hasSize(2)
                .contains("apple", "banana");
    }

    @DisplayName("수행 횟수 양수 입력시 정상적으로 추출한다.")
    @Test
    void getMoveCountFromUserWithValidInput() {

        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputHandler inputHandler = new InputHandler();

        int moveCount = inputHandler.getMoveCountFromUser();

        assertThat(moveCount).isEqualTo(5);
    }

    @DisplayName("수행 횟수 0 입력시 예외를 발생시킨다.")
    @Test
    void getMoveCountFromUserWithZeroInput() {

        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputHandler inputHandler = new InputHandler();

        assertThatThrownBy(() -> inputHandler.getMoveCountFromUser())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("1 이상의 숫자를 입력 해 주세요");
    }

    @DisplayName("수행 횟수 음수 입력시 예외를 발생시킨다.")
    @Test
    void getMoveCountFromUserWithNegativeInput() {

        String input = "-1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputHandler inputHandler = new InputHandler();

        assertThatThrownBy(() -> inputHandler.getMoveCountFromUser())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("양수만 입력 해 주세요.");
    }

    @DisplayName("수행 횟수 문자 입력시 예외를 발생시킨다.")
    @Test
    void getMoveCountFromUserContainsCharacterInput() {

        String input = "-1de\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputHandler inputHandler = new InputHandler();

        assertThatThrownBy(() -> inputHandler.getMoveCountFromUser())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("양수만 입력 해 주세요.");
    }


}