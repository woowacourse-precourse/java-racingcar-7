package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.game.Car;
import racingcar.game.GameDirector;
import racingcar.strategy.Condition;


import java.util.List;


class GameDirectorTest {
    @Test
    void run() {
        //given
        String carNames = "pobi,woni,jun";
        String count = "5";
        Condition condition = Condition.getCondition();
        GameDirector gameDirector = new GameDirector(carNames,count,condition);
        //when //then
        List<Car> matchResult = gameDirector.run();
        gameDirector.printWinner(matchResult);
    }
}