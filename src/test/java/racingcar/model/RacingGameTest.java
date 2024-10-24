package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("인원 3명, 진행 0번, 우승자 3명")
    void addPlayers() {
        // given
        Game game = new RacingGame();
        List<String> names = List.of("one", "two", "three");

        // when
        for (String name : names) {
            game.addPlayer(new Car(name));
        }

        // then
        assertEquals(3, game.getWinner().size());
    }

    @Test
    @DisplayName("인원 3명, 진행 1번, 우승자 1명")
    void progressOneAndOneWinnerTest() {
        // given
        Game game = new RacingGame();
        List<String> names = List.of("one", "two", "three");

        for (String name : names) {
            game.addPlayer(new Car(name));
        }

        // when
        assertRandomNumberInRangeTest(
                game::progress,
                MOVING_FORWARD, STOP, STOP
        );

        // then
        assertEquals(1, game.getWinner().size());
        assertEquals("one", game.getWinner().get(0));
    }

    @Test
    @DisplayName("인원 3명, 진행 1번, 우승자 2명")
    void progressOneAndTwoWinnerTest() {
        // given
        Game game = new RacingGame();
        List<String> names = List.of("one", "two", "three");

        for (String name : names) {
            game.addPlayer(new Car(name));
        }

        // when
        assertRandomNumberInRangeTest(
                game::progress,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );

        // then
        assertEquals(2, game.getWinner().size());
        assertEquals("one", game.getWinner().get(0));
        assertEquals("three", game.getWinner().get(1));
    }

    @Test
    @DisplayName("인원 3명, 진행 2번, 우승자 1명")
    void progressTwoAndOneWinnerTest() {
        // given
        Game game = new RacingGame();
        List<String> names = List.of("one", "two", "three");

        for (String name : names) {
            game.addPlayer(new Car(name));
        }

        // when
        assertRandomNumberInRangeTest(
                game::progress,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
        assertRandomNumberInRangeTest(
                game::progress,
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );

        // then
        assertEquals(1, game.getWinner().size());
        assertEquals("two", game.getWinner().get(0));
    }

    @Test
    @DisplayName("인원 3명, 진행 2번, 우승자 2명")
    void progressTwoAndTwoWinnerTest() {
        // given
        Game game = new RacingGame();
        List<String> names = List.of("one", "two", "three");

        for (String name : names) {
            game.addPlayer(new Car(name));
        }

        // when
        assertRandomNumberInRangeTest(
                game::progress,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
        assertRandomNumberInRangeTest(
                game::progress,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );

        // then
        assertEquals(2, game.getWinner().size());
        assertEquals("two", game.getWinner().get(0));
        assertEquals("three", game.getWinner().get(1));
    }

    @Test
    @DisplayName("인원 3명, 진행 3번, 우승자 3명")
    void progressThreeAndThreeWinnerTest() {
        // given
        Game game = new RacingGame();
        List<String> names = List.of("one", "two", "three");

        for (String name : names) {
            game.addPlayer(new Car(name));
        }

        // when
        assertRandomNumberInRangeTest(
                game::progress,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
        assertRandomNumberInRangeTest(
                game::progress,
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
        assertRandomNumberInRangeTest(
                game::progress,
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );

        // then
        assertEquals(3, game.getWinner().size());
        assertEquals("one", game.getWinner().get(0));
        assertEquals("two", game.getWinner().get(1));
        assertEquals("three", game.getWinner().get(2));
    }
}