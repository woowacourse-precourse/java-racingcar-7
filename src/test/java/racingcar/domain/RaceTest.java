package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class RaceTest {
    @Test
    void 주어진_시도횟수만큼_게임을_진행할_수_있다() {
        int totalRound = 4;
        List<String> names = List.of("car1", "car2");
        RaceRule rule = new RaceRule(() -> 4);
        Race race = new Race(totalRound, names, rule);

        // when
        race.proceed();
        race.proceed();

        // then
        race.proceed();
        assertThat(race.isGameEnd()).isFalse();

        race.proceed();
        assertThat(race.isGameEnd()).isTrue();
    }

    @Test
    void 주어진_시도횟수를_초과하여_게임을_진행할_수_없다() {
        int totalRound = 3;
        List<String> names = List.of("car1", "car2");
        RaceRule rule = new RaceRule(() -> 4);
        Race race = new Race(totalRound, names, rule);

        race.proceed();
        race.proceed();
        race.proceed();

        assertThrows(NoSuchElementException.class, race::proceed);
    }
}
