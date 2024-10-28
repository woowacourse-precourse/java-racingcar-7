package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarServiceTest {

    private RacingCarService racingCarService;
    private CarNameValidator carNameValidator;

    @BeforeEach
    void setUp() {
        carNameValidator = new CarNameValidator();
        racingCarService = new RacingCarService(carNameValidator);
    }

    @Test
    void 레이싱카_생성() {
        String input = "car1,car2,car3";
        racingCarService.createRacingCars(input);

        List<String[]> carInfo = racingCarService.extractCarNameAndAdvanceResult();

        assertThat(carInfo.size()).isEqualTo(3);
        List<String> expectedNames = Arrays.asList("car1", "car2", "car3");
        for (String[] car : carInfo) {
            assertThat(expectedNames).contains(car[0]);
            assertThat(car[1]).isEmpty();
        }
    }

    @Test
    void 분리된이름으로_레이싱카_생성() {
        String[] carNames = {"car1", "car2", "car3"};
        racingCarService.createRacingCarsBySplitCarsName(carNames);

        List<String[]> carInfo = racingCarService.extractCarNameAndAdvanceResult();

        assertThat(carInfo.size()).isEqualTo(3);
        assertThat(carInfo.get(0)[0]).isEqualTo("car1");
        assertThat(carInfo.get(1)[0]).isEqualTo("car2");
        assertThat(carInfo.get(2)[0]).isEqualTo("car3");
    }

    @Test
    void 자동차이름_분리() {
        String input = "car1, car2,car3 , car4";
        String[] expected = {"car1", "car2", "car3", "car4"};

        String[] result = racingCarService.splitCarsName(input);

        assertThat(result).containsExactly(expected);
    }

    @Test
    void 문자리스트를_문자열로변환() {
        List<Character> advanceResults = new ArrayList<>();
        advanceResults.add('A');
        advanceResults.add('B');
        advanceResults.add('C');

        String result = racingCarService.charListToString(advanceResults);

        assertThat(result).isEqualTo("ABC");
    }
}
