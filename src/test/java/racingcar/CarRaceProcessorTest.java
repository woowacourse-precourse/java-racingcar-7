package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceProcessorTest {

    @Test
    @DisplayName("영문,한글,공백,(,)외에 다른 문자가 포함된 경우 에러를 발생시킨다.")
    void invalidUserInput() {
        final String invalidCarNames = "pobi, woni, jun, #pobi";
        assertThrows(IllegalArgumentException.class, () -> {
            CarRaceProcessor.setUpRacingCars(invalidCarNames);
        });
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상, 0자인 경우 에러를 발생시킨다.")
    void invalidCarNameLength() {
        final String invalidCarNames = "pobi, woni, jun, pobiwonijun";
        final String noneCarNames = "";
        assertThrows(IllegalArgumentException.class, () -> {
            CarRaceProcessor.setUpRacingCars(invalidCarNames);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            CarRaceProcessor.setUpRacingCars(noneCarNames);
        });
    }

    @Test
    @DisplayName("(,)구분자와 이름사이 공백을 제거한다.")
    void stripAndSplitCarNames() {
        final String inputCarNames = "p o b i,won i,  준12 3 4";
        Assertions.assertThat(CarRaceProcessor.setUpRacingCars(inputCarNames).keySet())
                .containsExactly("pobi", "woni", "준1234");
    }

    @Test
    @DisplayName("runRace 한 번당 1칸 전진 또는 정지한다.")
    void runSingleRound() {
        final Map<String, Integer> raceStatus = CarRaceProcessor.setUpRacingCars("pobi, woni, jun");
        Assertions.assertThat(CarRaceProcessor.runSingleRound(raceStatus).values())
                .allSatisfy(value -> Assertions.assertThat(value).isIn(0, 1));
    }

    @Test
    @DisplayName("raceStatus에서 가장 많이 전진한 자동차를 찾는다.")
    void getWinners() {
        final Map<String, Integer> raceStatus1 = Map.of("pobi", 5, "woni", 5, "jun", 4);
        final Map<String, Integer> raceStatus2 = Map.of("pobi", 0, "woni", 0, "jun", 0);
        Assertions.assertThat(CarRaceProcessor.getWinners(raceStatus1))
                .containsExactlyInAnyOrder("pobi", "woni");
        Assertions.assertThat(CarRaceProcessor.getWinners(raceStatus2))
                .containsExactlyInAnyOrder("pobi", "woni", "jun");
    }
}