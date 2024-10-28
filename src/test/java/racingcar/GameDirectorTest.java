package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.game.GameDirector;

import java.util.List;


class GameDirectorTest {
    @Test
    void run() {
        //given
        int count = 5;
        GameDirector gameDirector = new GameDirector(List.of("pobi", "woni", "jun"), count);
        //when //then
        gameDirector.run();

    }
}