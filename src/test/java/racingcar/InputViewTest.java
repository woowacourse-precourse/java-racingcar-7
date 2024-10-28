package racingcar;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

class InputViewTest {

    @Test
    void 입력된_문자열을_리스트로_저장() {
        //given
        InputView input = new InputView();
        String playerNameInput = "pobi,woni,jun";

        //when
        InputStream in = new ByteArrayInputStream(playerNameInput.getBytes());
        System.setIn(in);
        List<String> result = input.printStart();

        //then
        Assertions.assertThatList(result)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 입력된_문자열을_정수로_반환() {
        //givenR
        InputView input = new InputView();
        String inputNumber = "5";

        //when
        InputStream in = new ByteArrayInputStream(inputNumber.getBytes());
        System.setIn(in);
        int result = input.printRounds();

        //then
        Assertions.assertThat(result).isEqualTo(5);
    }

}