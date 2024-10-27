package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("CarA", "CarB", "CarC");
        racingGame = new RacingGame(carNames);
    }

    @Test
    void testGameInitializesCarsCorrectly() {
        List<RacingCar> cars = racingGame.getCars();
        assertEquals(3, cars.size(), "Racing game should initialize correct number of cars");
        assertEquals("CarA", cars.get(0).getName(), "First car name should match");
    }

    @Test
    void testPlayOneTurnMovesCarsBasedOnRandomValue() {
        racingGame.playOneTurn();
        boolean anyCarMoved = racingGame.getCars().stream()
            .anyMatch(car -> car.getPosition() > 0);
        assertTrue(anyCarMoved, "At least one car should have moved after one turn");
    }

    @Test
    void testGetWinnerNames() {
        // Move each car to specific positions to simulate a game
        racingGame.getCars().get(0).move(true);  // CarA moves
        racingGame.getCars().get(1).move(true);  // CarB moves
        racingGame.getCars().get(1).move(true);  // CarB moves again
        racingGame.getCars().get(2).move(false); // CarC doesn't move

        List<String> winners = racingGame.getWinnerNames();
        assertEquals(List.of("CarB"), winners, "CarB should be the winner with the highest position");
    }
}
