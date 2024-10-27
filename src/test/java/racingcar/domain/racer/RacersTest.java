package racingcar.domain.racer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.racer.utils.Condition;

class RacersTest {

    @Test
    @DisplayName("선수를 추가할 수 있다.")
    void givenRacerAndAddRacers_whenGetRacers_thenRegistered() {
        Racers racers = new Racers();
        racers.add(new Racer("car1", new Condition(() -> 4)));

        List<Racer> result = racers.getRacers();

        assertThat(result.getFirst().getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("선수를 추가한 뒤, 차를 이동할 경우 이동한다.")
    void givenRacerAndAddRacers_whenMoveCars_thenForward() {
        Racers racers = new Racers();
        racers.add(new Racer("car1", new Condition(() -> 4)));

        racers.moveCars();

        List<Racer> result = racers.getRacers();
        assertThat(result.getFirst().getPosition()).isOne();
    }

    @Test
    @DisplayName("선수를 추가한 뒤, 차를 이동할 경우 이동하지 않는다.")
    void givenRacerAndAddRacers_whenMoveCars_thenNotForward() {
        Racers racers = new Racers();
        racers.add(new Racer("car1", new Condition(() -> 0)));

        racers.moveCars();

        List<Racer> result = racers.getRacers();
        assertThat(result.getFirst().getPosition()).isZero();
    }

}