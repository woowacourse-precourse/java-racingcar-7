package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;
    private List<Car> carList;

    @BeforeEach
    void 초기화() {
        carList = new ArrayList<>();
        carList.add(new Car("Car1"));
        carList.add(new Car("Car2"));
        carList.add(new Car("Car3"));
        game = new Game(5, carList);
    }

    @Test
    void Game_객체는_정상적으로_생성되어야_한다() {
        assertEquals(5, game.getPlayCount());
        assertEquals(3, game.getCarList().size());
        assertTrue(game.getWinnerList().isEmpty());
    }

    @Test
    void getPlayCount_메서드는_올바른_플레이_횟수를_반환해야_한다() {
        assertEquals(5, game.getPlayCount());
    }

    @Test
    void getCarList_메서드는_올바른_자동차_목록을_반환해야_한다() {
        assertEquals(carList, game.getCarList());
    }

    @Test
    void addWinner_메서드는_우승자_목록에_자동차를_추가해야_한다() {
        Car winner = new Car("WinnerCar");
        game.addWinner(winner);

        assertEquals(1, game.getWinnerList().size());
        assertEquals("WinnerCar", game.getWinnerList().get(0).getName());
    }

    @Test
    void getWinnerList_메서드는_올바른_우승자_목록을_반환해야_한다() {
        Car winner1 = new Car("Winner1");
        Car winner2 = new Car("Winner2");

        game.addWinner(winner1);
        game.addWinner(winner2);

        List<Car> expectedWinnerList = new ArrayList<>();
        expectedWinnerList.add(winner1);
        expectedWinnerList.add(winner2);

        assertEquals(expectedWinnerList, game.getWinnerList());
    }
}