package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.game.Car;
import racingcar.game.GameDirector;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomNumStrategy;

import java.util.List;


class GameDirectorTest {
    @Test
    void run() {
        //given
        String carNames = "pobi,woni,jun";
        String count = "5";
        MoveStrategy strategy = new RandomNumStrategy();
        GameDirector gameDirector = new GameDirector(carNames,count,strategy);
        //when //then
        List<Car> matchResult = gameDirector.run();
        gameDirector.printWinner(matchResult);
    }
}