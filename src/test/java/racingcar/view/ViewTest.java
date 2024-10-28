package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.InputDto;

public class ViewTest {


    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("ConsoleInput으로 입력 포맷 출력 및 입력 받기 테스트")
    @Test
    void inputTest() {

        final String USER_INPUT_CARS = "pobi,woni,jun";
        final String USER_INPUT_CNT = "5";
        final String USER_INPUT = USER_INPUT_CARS + "\n" + USER_INPUT_CNT;

        System.setIn(createUserInput(USER_INPUT));

        InputView consoleInputView = new ConsoleInputView();
        InputDto.RequestInputDto requestInputDto = consoleInputView.readInput();

        assertThat(requestInputDto.getInputCars()).contains(USER_INPUT_CARS.split(","));
        assertThat(requestInputDto.getInputCnt()).isEqualTo(Integer.parseInt(USER_INPUT_CNT));
    }

    @DisplayName("자동차 이름에 쉼표(,)가 연속적으로 존재하는 경우 예외 발생")
    @Test
    void inputExceptionTest1() {

        final String USER_INPUT_CARS = "pobi,,,,,,,,woni,jun";
        final String USER_INPUT_CNT = "5";
        final String USER_INPUT = USER_INPUT_CARS + "\n" + USER_INPUT_CNT;

        System.setIn(createUserInput(USER_INPUT));

        InputView consoleInputView = new ConsoleInputView();

        assertThrows(IllegalArgumentException.class, consoleInputView::readInput);
    }

    @DisplayName("자동차 이름에 빈 문자열을 입력했을 때 IllegalArgumentException 발생")
    @Test
    void inputExceptionTest2() {

        final String USER_INPUT_CARS = "";
        final String USER_INPUT_CNT = "5";
        final String USER_INPUT = USER_INPUT_CARS + "\n" + USER_INPUT_CNT;

        System.setIn(createUserInput(USER_INPUT));

        InputView consoleInputView = new ConsoleInputView();

        assertThrows(IllegalArgumentException.class, consoleInputView::readInput);
    }

    @DisplayName("자동차 이름에 공백 문자열을 입력했을 때 IllegalArgumentException 발생")
    @Test
    void inputExceptionTest3() {

        final String USER_INPUT_CARS = "            ";
        final String USER_INPUT_CNT = "5";
        final String USER_INPUT = USER_INPUT_CARS + "\n" + USER_INPUT_CNT;

        System.setIn(createUserInput(USER_INPUT));

        InputView consoleInputView = new ConsoleInputView();

        assertThrows(IllegalArgumentException.class, consoleInputView::readInput);
    }

    @DisplayName("자동차 이름에 입력값을 잘못된 형식으로 입력했을 때 IllegalArgumentException 발생 ")
    @Test
    void inputExceptionTest4() {
        final String[] USER_INPUT_CARS = {",pobi", "james,pobi,", "james,pobi:", "james/pobi"};
        final String USER_INPUT_CNT = "5";

        InputView consoleInputView = new ConsoleInputView();

        for (String USER_INPUT_CARS_ITEM : USER_INPUT_CARS) {
            String USER_INPUT = USER_INPUT_CARS_ITEM + "\n" + USER_INPUT_CNT;

            System.setIn(createUserInput(USER_INPUT));

            assertThrows(IllegalArgumentException.class, consoleInputView::readInput);
            Console.close();
        }
    }

    @DisplayName("자동차 이름이 5자 이상일 때 IllegalArgumentException 발생 ")
    @Test
    void inputExceptionTest5() {
        final String USER_INPUT_CARS = "pobi,abcdefg";
        final String USER_INPUT_CNT = "5";
        final String USER_INPUT = USER_INPUT_CARS + "\n" + USER_INPUT_CNT;

        System.setIn(createUserInput(USER_INPUT));

        InputView consoleInputView = new ConsoleInputView();

        assertThrows(IllegalArgumentException.class, consoleInputView::readInput);

    }

    InputStream createUserInput(final String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
