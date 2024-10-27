package racingcar.domain.racer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.racer.movecondition.impl.RandomNumberGenerator;

class RacersTest {

    @Test
    @DisplayName("선수를 추가할 수 있다.")
    void givenRacerAndAddRacers_whenGetRacers_thenRegistered() {
        // given
        Racers racers = Racers.of(List.of("car1"), new RandomNumberGenerator());

        // when
        List<Racer> result = racers.racers();

        // then
        assertThat(result.getFirst().getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("선수를 추가한 뒤, 차를 이동할 경우 이동한다.")
    void givenRacerAndAddRacers_whenMoveCars_thenForward() {
        // given
        Racers racers = Racers.of(List.of("car1"), () -> 4);

        // when
        racers.moveCars();

        // then
        List<Racer> result = racers.racers();
        assertThat(result.getFirst().getPosition()).isOne();
    }

    @Test
    @DisplayName("선수를 추가한 뒤, 차를 이동할 경우 이동하지 않는다.")
    void givenRacerAndAddRacers_whenMoveCars_thenNotForward() {
        // given
        Racers racers = Racers.of(List.of("car1"), () -> 0);

        // when
        racers.moveCars();

        // then
        List<Racer> result = racers.racers();
        assertThat(result.getFirst().getPosition()).isZero();
    }

}