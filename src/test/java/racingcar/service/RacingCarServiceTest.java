package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

class RacingCarServiceTest {

    private RacingCarService racingCarService;

    @BeforeEach
    void setUp() {
        racingCarService = new RacingCarService();
    }

    @DisplayName("여러 자동차로 게임을 실행할 때 올바른 자동차 목록 반환")
    @Test
    void testRunGame_withMultipleCars() {
        List<String> inputCars = Arrays.asList("pobi", "woni", "jun");
        int trial = 5;

        List<RacingCar> racingRacingCars = racingCarService.runGame(inputCars, trial);

        assertEquals(3, racingRacingCars.size());
        assertEquals("pobi", racingRacingCars.get(0).getName());
        assertEquals("woni", racingRacingCars.get(1).getName());
        assertEquals("jun", racingRacingCars.get(2).getName());
    }

    @DisplayName("trial을 5로 설정할 경우, 최대 location이 5이하인지 테스트")
    @Test
    void testRunGame_withFiveTrial() {
        List<String> inputCars = Arrays.asList("pobi", "woni", "jun");
        int trial = 5;

        List<RacingCar> racingRacingCars = racingCarService.runGame(inputCars, trial);
        int maxLocation = racingRacingCars.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .getAsInt();

        assertThat(maxLocation).isLessThanOrEqualTo(trial);
    }


}