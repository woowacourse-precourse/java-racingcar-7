package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }


    @DisplayName("자동차 이름 입력 함수 안내 메시지 확인")
    @Test
    void checkViewCarNameInputPrompt(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        UserInput userInput = new UserInput();

        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        userInput.promptCarNameUserInput();

        assertEquals("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n", outputStream.toString());
    }
    @DisplayName("자동차 이름 입력 함수 입력값 확인")
    @Test
    void checkViewInputCarName(){
        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UserInput userInput = new UserInput();

        assertEquals(input, userInput.promptCarNameUserInput());
    }

    @DisplayName("시도 횟수 입력 함수 안내 메시지 확인")
    @Test
    void checkViewTryNumInputPrompt(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        UserInput userInput = new UserInput();

        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        userInput.promptTryNumUserInput();

        assertEquals("시도할 횟수는 몇 회인가요?\n", outputStream.toString());
    }
    @DisplayName("시도 횟수 입력 함수 입력값 확인")
    @Test
    void checkViewInputTryNum(){
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UserInput userInput = new UserInput();

        assertEquals(input, userInput.promptTryNumUserInput());
    }
}
