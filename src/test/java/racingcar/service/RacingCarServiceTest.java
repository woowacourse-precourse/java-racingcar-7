package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingResult;
import racingcar.model.Car;

class RacingCarServiceTest {

    private RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarService(() -> 4);
    }

    @DisplayName("")
    @Test
    void startRacingGame() {
        // given
        Car car1 = Car.of("car1");
        Car car2 = Car.of("car2");
        Car car3 = Car.of("car3");

        String resultString = "car1 : -\n"
                + "car2 : -\n"
                + "car3 : -\n\n"
                + "car1 : --\n"
                + "car2 : --\n"
                + "car3 : --\n\n"
                + "car1 : ---\n"
                + "car2 : ---\n"
                + "car3 : ---\n\n";

        // when
        RacingResult racingResult = racingCarService.startRacingGame(List.of(car1, car2, car3), 3);

        // then
        Assertions.assertThat(car1.getTrace().toString()).isEqualTo("---");
        Assertions.assertThat(car2.getTrace().toString()).isEqualTo("---");
        Assertions.assertThat(car3.getTrace().toString()).isEqualTo("---");
        Assertions.assertThat(car1.getPos()).isEqualTo(3);
        Assertions.assertThat(car2.getPos()).isEqualTo(3);
        Assertions.assertThat(car3.getPos()).isEqualTo(3);
        Assertions.assertThat(racingResult.getResult()).isEqualTo(resultString);
        Assertions.assertThat(racingResult.getWinnerNames()).hasSize(3)
                .containsExactly("car1", "car2", "car3");
    }
}