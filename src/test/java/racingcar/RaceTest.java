package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Race;
import racingcar.domain.strategy.MovableStrategy;
import racingcar.domain.strategy.RandomMovableStrategy;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    private Race race;
    private MovableStrategy strategy;

    @BeforeEach
    void setUp() {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        race = new Race(carNames);
        strategy = new RandomMovableStrategy();
    }

    @Test
    void raceRound_moves_cars() {
        race.raceRound(strategy);
        assertTrue(race.getCars().stream().anyMatch(car -> car.getPosition() > 0));
    }
    @Test
    void getWinners_returns_correct_winners() {
        race.getCars().get(0).move();
        race.getCars().get(1).move();
        List<String> winners = race.getWinners();
        assertTrue(winners.contains("pobi"));
        assertTrue(winners.contains("woni"));
        assertEquals(2, winners.size());
    }

}
