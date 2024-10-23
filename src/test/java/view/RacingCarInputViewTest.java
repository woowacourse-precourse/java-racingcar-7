package view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        System.setIn(createInput("dodo,moo,hahaha"));
        Scanner scanner = new Scanner(System.in);

        //when
        String name = inputView.receiveName();
        System.out.println(name);

        //then
        Assertions.assertThat(name).isEqualTo("dodo,moo,hahaha");

    }

    @DisplayName("시도횟수를 입력받을 수 있다. inputView 를 출력한다.")
    @Test
    void receiveTryCount() {
        //given
        RacingCarInputView inputView = new RacingCarInputView();
        System.setIn(createInput("3"));
        Scanner scanner = new Scanner(System.in);

        //when
        String count = inputView.receiveTryCount();
        System.out.println(count);

        //then
        Assertions.assertThat(count).isEqualTo("3");

    }

}