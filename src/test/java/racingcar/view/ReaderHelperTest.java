package racingcar.view;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import racingcar.validate.Validator;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReaderHelperTest {

    @Test
    @DisplayName("두명의 선수, 3회 입력")
    void twoPlayer() {
        // given
        ReaderHelper readerHelper = new ReaderHelper();
        setInput("player1,player2\n3");
        Validator validator = new Validator();

        // when
        List<String> result = readerHelper.readPlayerName();
        int playTime = readerHelper.readPlayTime(validator);

        // then
        assertEquals(2, result.size());
        assertEquals("player1", result.get(0));
        assertEquals("player2", result.get(1));
        assertEquals(3, playTime);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}