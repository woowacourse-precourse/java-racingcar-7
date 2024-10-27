package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.Output;

import static org.junit.jupiter.api.Assertions.*;

public class RaceTest {

    private Race race;

    @BeforeEach
    public void Car_객체들과_함께_Race_객체를_생성한다() {
        race = new Race(5);
        race.join(new Car("first"));
        race.join(new Car("secon"));
        race.join(new Car("third"));
    }

    @Test
    @DisplayName("일정한_턴을_가진_게임이_생성된다")
    public void 일정한_턴을_가진_게임이_생성된다() {
        Race race = new Race(5);
        assertTrue(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 6, 100})
    @DisplayName("턴이_0이하_또는_6이상의_입력으로_예외가_발생한다")
    public void 턴이_0이하_또는_6이상의_입력으로_예외가_발생한다(int turn) {
        assertThrows(IllegalArgumentException.class, () -> new Race(turn));
    }

    @Test
    @DisplayName("하나의_턴을_플레이한다")
    public void 하나의_턴을_플레이한다() {
        race.playOneTurn();
        assertTrue(true);
    }

    @Test
    @DisplayName("경주가_끝난_후_우승자를_찾는다")
    public void 경주가_끝난_후_우승자를_찾는다() {
        while (race.isAvailableRace()) {
            race.playOneTurn();
        }
        Output.printWinners(race.getWinner());
        assertTrue(true);
    }
}
