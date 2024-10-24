package view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import policy.RacingCarPolicy;

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
        Scanner scanner = new Scanner(System.in);

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
                .hasMessage("이름의 길이는 5를 넘을 수 없습니다.");
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
                .hasMessage("구분자를 바르게 입력해주세요.");
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
                .hasMessage("중복된 이름은 입력할 수 없습니다.");
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
                        inputView.validateBlankAndThrow("이름",input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에는 공백만 입력할 수 없습니다.");
    }

    @DisplayName("시도횟수를 입력받을 수 있다. inputView 를 출력한다.")
    @Test
    void receiveTryCount() {
        //given
        RacingCarInputView inputView = new RacingCarInputView();
        System.setIn(createInput("3"));
        Scanner scanner = new Scanner(System.in);

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
                .hasMessage("시도횟수는 양수로 입력해주세요");

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
                .hasMessage("시도횟수는 9,223,372,036,854,775,807를 넘을 수 없습니다.");

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
                .hasMessage("시도횟수는 숫자로 입력해 주세요.");

    }


}