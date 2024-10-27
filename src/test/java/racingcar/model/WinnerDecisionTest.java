package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerDecisionTest {
    @Test
    void shouldDetermineSoleWinner() {
        Car carA = Car.create("CarA");
        Car carB = Car.create("CarB");
        carA.move(5);

        List<Car> winners = WinnerDecision.determineWinners(List.of(carA, carB));
        assertThat(winners).hasSize(1).contains(carA);
    }

    @Test
    void shouldDetermineCoWinners() {
        Car carA = Car.create("CarA");
        Car carB = Car.create("CarB");
        carA.move(5);
        carB.move(5);

        List<Car> winners = WinnerDecision.determineWinners(List.of(carA, carB));
        assertThat(winners).hasSize(2).contains(carA, carB);
    }

}