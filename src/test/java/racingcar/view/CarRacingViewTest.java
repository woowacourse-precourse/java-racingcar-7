package racingcar.view;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

class CarRacingViewTest extends ViewTest {

    @Test
    @DisplayName("displayCurrentStatus는 진행 결과를 안내한다.")
    void displayCurrentStatus_AnnounceCorrectly() {
        // given
        List<RacingCar> racingCars = List.of(
                new RacingCar("aaa", 2),
                new RacingCar("bbb", 4),
                new RacingCar("ccc", 3)
        );

        String expectedOutput = """
                aaa : --
                bbb : ----
                ccc : ---""";

        // when
        CarRacingView.displayCurrentStatus(racingCars);

        // then
        Assertions.assertThat(output()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("displayRaceResult는 단독 우승자일때 우승자를 정확하게 안내한다.")
    void displayRaceResult_WhenUniqueWinner_AnnounceCorrectly() {
        // given
        List<RacingCar> winningRacingCars = List.of(
                new RacingCar("aaa")
        );

        String expectedOutput = "최종 우승자 : aaa";

        // when
        CarRacingView.displayRaceResult(winningRacingCars);

        // then
        Assertions.assertThat(output()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("displayRaceResult는 공동 우승자일때 쉼표(,)를 구분자로 하여 우승자를 안내한다.")
    void displayRaceResult_WhenMultipleWinners_AnnounceCorrectly() {
        // given
        List<RacingCar> winningRacingCars = List.of(
                new RacingCar("aaa"),
                new RacingCar("bbb")
        );

        String expectedOutput = "최종 우승자 : aaa, bbb";

        // when
        CarRacingView.displayRaceResult(winningRacingCars);

        // then
        Assertions.assertThat(output()).isEqualTo(expectedOutput);
    }
}
