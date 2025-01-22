package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameContextTest {

    @Test
    void 예외_테스트_비정상_사용자_수() {
        //given
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            builder.append(i);
            builder.append(",");
        }
        builder.append("100");
        String input = builder.toString();
        int round = 100;

        //when, then
        assertThrows(IllegalArgumentException.class, () -> GameContext.getGameContext(input, round));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10001})
    void 객체생성_예외테스트_비정상_라운드(int round) {
        //given
        String input = "poby,GG";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> GameContext.getGameContext(input, round));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10000})
    void 객체생성_성공_정상_라운드(int round) {
        //given
        String input = "poby,GG";

        //when
        GameContext gameContext = GameContext.getGameContext(input, round);

        //then
        assertEquals(round, gameContext.getRound());
    }

    @Test
    void 성공_단독우승() {
        //given
        int round = 10;
        Car poby = new Car("poby", () -> Randoms.pickNumberInRange(5, 9));
        Car GG = new Car("GG", () -> Randoms.pickNumberInRange(0, 3));

        List<Car> cars = new ArrayList<>();
        cars.add(poby);
        cars.add(GG);

        GameContext gameContext = GameContext.getGameContext(cars, round);

        //when
        gameContext.run();

        //then
        assertEquals(1, gameContext.findWinners().size());
        assertEquals("poby", gameContext.findWinners().getFirst());
    }

    @Test
    void 성공_공동우승() {
        //given
        int round = 10;
        Car poby = new Car("poby", () -> 5);
        Car GG = new Car("GG", () -> 5);

        List<Car> cars = new ArrayList<>();
        cars.add(poby);
        cars.add(GG);

        GameContext gameContext = GameContext.getGameContext(cars, round);

        //when
        gameContext.run();

        //then
        assertEquals(2, gameContext.findWinners().size());
        assertEquals("poby", gameContext.findWinners().getFirst());
        assertEquals("GG", gameContext.findWinners().getLast());
    }
}