package view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.policy.RacingCarPolicy;
import racingcar.exception.ExceptionMessage;
import racingcar.view.RacingCarInputView;

class RacingCarInputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    InputStream createInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("이름값을 입력받을 수 있다. inputView 를 출력한다.")
    @Test
    void receiveName() {
        //given
        RacingCarInputView inputView = new RacingCarInputView();
        System.setIn(createInput("dodo,moo,haha"));

        //when
        String name = inputView.receiveName(new RacingCarPolicy());
        System.out.println(name);

        //then
        Assertions.assertThat(name).isEqualTo("dodo,moo,haha");
    }

    @DisplayName("이름의 길이는 5를 넘을 수 없다.")
    @Test
    void validateNameLengthOrThrow() {
        //given
        RacingCarInputView inputView = new RacingCarInputView();
        String input = "dada,dodododo,fafa";
        String[] split = input.split(",");

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        inputView.validateNameLengthOrThrow(split, new RacingCarPolicy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MAX_LENGTH_EXCEEDED.getMessage());
    }

    @DisplayName("구분자를 바르게 입력해야 한다.")
    @Test
    void validateNoSeparatorOrThrow() {
        //given
        RacingCarInputView inputView = new RacingCarInputView();
        String input = "dada:dodododo:fafa";

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        inputView.validateNoSeparatorOrThrow(input, new RacingCarPolicy()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DELIMITER_NOT_VALID.getMessage());
    }

    @DisplayName("중복된 이름은 입력할 수 없다.")
    @Test
    void duplicateNameAndThrow() {
        //given
        RacingCarInputView inputView = new RacingCarInputView();
        String input = "dada,dodo,fafa,dodo";
        String[] split = input.split(",");

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        inputView.duplicateNameAndThrow(split))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_NAME_NOT_ALLOWED.getMessage());
    }

    @DisplayName("공백만 입력할 수 없다.")
    @Test
    void validateBlankAndThrow() {
        //given
        RacingCarInputView inputView = new RacingCarInputView();
        String input = "";

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        inputView.validateBlankAndThrow(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_BLANK_INPUT.getMessage());
    }

    @DisplayName("시도횟수를 입력받을 수 있다. inputView 를 출력한다.")
    @Test
    void receiveTryCount() {
        //given
        RacingCarInputView inputView = new RacingCarInputView();
        System.setIn(createInput("3"));

        //when
        Long count = inputView.receiveTryCount();
        System.out.println(count);

        //then
        Assertions.assertThat(count).isEqualTo(3L);

    }

    @DisplayName("음수는 입력할 수 없다.")
    @Test
    void validateNegativeAndThrow() {
        //given
        RacingCarInputView inputView = new RacingCarInputView();

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        inputView.validateNegativeAndThrow(-1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_NON_POSITIVE_COUNT.getMessage());

    }

    @DisplayName("Long 범위 입력값을 넘길 수 없다.")
    @Test
    void validateLongLengthAndThrow() {
        //given
        RacingCarInputView inputView = new RacingCarInputView();

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        inputView.validateLongLengthAndThrow("12312312312312312323"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MAX_COUNT_LENGTH_EXCEEDED.getMessage());

    }

    @DisplayName("시도횟수는 숫자만 입력할 수 있다.")
    @Test
    void validateInputNumber() {
        //given
        RacingCarInputView inputView = new RacingCarInputView();

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        inputView.validateInputNumber("다섯"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_COUNT_FORMAT.getMessage());

    }


}