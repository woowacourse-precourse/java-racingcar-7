package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RacingTest {

    private static final RacingCars racingCars = new RacingCars();
    private final Racing racing = new Racing(racingCars);

    @BeforeAll
    static void setUp() {
        IntStream.range(0, 3)
            .forEach(i -> racingCars.add(new RacingCar("name" + i, 0)));
    }

    @Test
    void 레이싱카들이_경주하여_우승자를_반환한다() {
        //given & when
        racing.moveCars();

        //then
        assertThat(racing.getWinnerCarNames()).containsAnyOf("name0", "name1", "name2");
    }

    @Test
    void 레이싱카들의_이름과_위치_표시를_출력한다() {
        //given
        racing.moveCars();

        //when
        String string = racing.toString();

        //then
        assertThat(string).contains("name0", "name1", "name2", "-");
    }

}
