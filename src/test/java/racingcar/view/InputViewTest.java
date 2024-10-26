package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.BlankInputException;

import java.io.ByteArrayInputStream;


class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("빈 문자열 입력 시 예외를 발생한다.")
    void validateNonEmptyString() {
        //given
        String input = "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when & then
        Assertions.assertThrows(BlankInputException.class, InputView::inputCarNames);
    }

    @Test
    @DisplayName("공백 입력 시 예외를 발생한다.")
    void validateNonWhiteSpace() {
        //given
        String input = " ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when & then
        Assertions.assertThrows(BlankInputException.class, InputView::inputCarNames);
    }
}