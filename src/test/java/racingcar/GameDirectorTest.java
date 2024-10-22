package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameDirectorTest {
    @Test
    void run() {
        //given
        String carNames = "pobi,woni,jun";
        String count = "5";
        GameDirector gameDirector = new GameDirector(carNames,count);
        //when //then
        gameDirector.run();
    }
}