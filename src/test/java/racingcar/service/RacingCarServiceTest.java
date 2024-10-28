package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.validator.RacingCarNameValidator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarServiceTest {

    private RacingCarService racingCarService;
    private RacingCarNameValidator racingCarNameValidator;

    @BeforeEach
    void setUp() {
        racingCarNameValidator = new RacingCarNameValidator();
        racingCarService = new RacingCarService(racingCarNameValidator);
    }

    @Test
    void 레이싱카_생성() {
        String input = "car1,car2,car3";
        racingCarService.createRacingCars(input);

        List<String[]> carInfo = racingCarService.getCarNamesAndAdvanceResults();

        assertThat(carInfo.size()).isEqualTo(3);
        List<String> expectedNames = Arrays.asList("car1", "car2", "car3");
        for (String[] car : carInfo) {
            assertThat(expectedNames).contains(car[0]);
            assertThat(car[1]).isEmpty();
        }
    }
}
