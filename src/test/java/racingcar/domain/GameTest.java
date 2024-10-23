package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void 경기_시작할떄_게임_데이터_정보_저장() {
        String input = "pobi,jun,woni\n4\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Game game = new Game();
        game.startGame();

        assertEquals(3, game.getCars().size());
        assertEquals("pobi", game.getCars().get(0).getName());
        assertEquals("jun", game.getCars().get(1).getName());
        assertEquals("woni", game.getCars().get(2).getName());
        assertEquals(4, game.getMoveNumber());
    }
}
