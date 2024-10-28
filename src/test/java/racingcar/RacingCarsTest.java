package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @Test
    void getWinner_1명의_경우() {
        // given
        ArrayList<String> carNames = new ArrayList<>(List.of("a"));
        RacingCars racingCars = new RacingCars(carNames);

        // when
        String winner = racingCars.getWinner();

        // then
        assertThat(winner).isEqualTo("a");
    }

    @Test
    void getWinner_여러명의_경우() {
        // given
        ArrayList<String> carNames = new ArrayList<>(List.of("a", "b"));
        RacingCars racingCars = new RacingCars(carNames);

        // when
        String winner = racingCars.getWinner();

        // then
        assertThat(winner).isEqualTo("a,b");
    }

    @Test
    void moveEachCarsIfPossible_정지_경우() {
        // given
        ArrayList<String> carNames = new ArrayList<>(List.of("a", "b"));
        RacingCars racingCars = new RacingCars(carNames);

        // when
        racingCars.moveEachCarsIfPossible(0, 3);

        // then
        assertThat(racingCars.getRacingCars()).extracting("position").containsExactly(0, 0);
    }

    @Test
    void moveEachCarsIfPossible_전진_경우() {
        // given
        ArrayList<String> carNames = new ArrayList<>(List.of("a", "b"));
        RacingCars racingCars = new RacingCars(carNames);

        // when
        racingCars.moveEachCarsIfPossible(4, 9);

        // then
        assertThat(racingCars.getRacingCars()).extracting("position").containsExactly(1, 1);
    }

    @Test
    void printEachCarsStatus() {
        // given
        ArrayList<String> carNames = new ArrayList<>(List.of("a", "b"));
        RacingCars racingCars = new RacingCars(carNames);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        racingCars.printEachCarsStatus();

        // then
        assertThat(out.toString()).isEqualTo("a : \r\nb : \r\n\r\n");
    }

}