package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.BlankInputException;
import racingcar.exception.CarNameFormatException;

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

    @ParameterizedTest
    @DisplayName("입력받은 자동차 이름이 쉼표(,)로 구분되지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"a.b.c,", "a;b;c", "a/b/c", "a-b-c", "a+b+c"})
    void validateCommaDelimitedNames(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when & then
        Assertions.assertThrows(CarNameFormatException.class, InputView::inputCarNames);
    }

    @ParameterizedTest
    @DisplayName("입력받은 자동차 이름들의 사이가 아닌 바깥에 쉼표가 있는 경우 예외가 발생한다.")
    @ValueSource(strings = {"a,b,c,", ",a,b,c", ",a,b,c,", ",abc", "abc,"})
    void validateCommaBetweenCarNames(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when & then
        Assertions.assertThrows(CarNameFormatException.class, InputView::inputCarNames);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름에 특수문자가 올 경우 예외를 발생한다.")
    @ValueSource(strings = {"a,b,.", "a,;,c", "@,@,@", "*,*,*"})
    void validateNonSpecialCharacter(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when & then
        Assertions.assertThrows(CarNameFormatException.class, InputView::inputCarNames);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름에 알파벳, 숫자, 한글을 입력할 수 있다.")
    @ValueSource(strings = {"a,b,c", "1,2,3", "가,나,다"})
    void validateAlphabetAndNumberAndKorean(String input) {
        //given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when & then
        org.assertj.core.api.Assertions.assertThatCode(InputView::inputCarNames)
                .doesNotThrowAnyException();
    }
}