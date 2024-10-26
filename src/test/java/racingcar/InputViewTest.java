package racingcar;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
//
//    @Test
//    void printRounds() {
//    }

}