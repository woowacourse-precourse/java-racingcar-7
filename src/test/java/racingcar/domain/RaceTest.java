package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    Race race;

    @BeforeEach
    public void set(){
        String[] names = {"pobi", "woni"};
        int count = 3;
        race = new Race(names, count);
    }

    @Test
    public void testRaceCars(){
        race.raceCars();

        List<Round> rounds = race.getRounds();
        //시도 횟수와 라운드가같은지
        assertEquals(3, rounds.size());
    }

    @Test
    public void testGetRounds() {
        race.raceCars();

        List<Round> rounds = race.getRounds();

        Round firstRound = rounds.get(0);
        assertTrue(firstRound.getCarLocation().containsKey("pobi"));
    }

    @Test
    public void TestGetWinner(){
        race.raceCars();
        List<String> winners = race.getWinner();

        assertTrue(winners.size()>0);

    }

}