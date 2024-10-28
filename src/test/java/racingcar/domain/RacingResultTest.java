package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingResultTest {

    @Test
    @DisplayName("경주 자동차의 위치에 따라 우승자를 선정한다.")
    void selectWinners() {
        //given
        List<String> carNames = List.of("java", "go", "ruby", "react");
        RacingCenter racingCenter = new RacingCenter();
        RacingCars racingCars = new RacingCars(racingCenter.registerCars(carNames));

        //when
        List<Integer> numbers = List.of(2, 1, 7, 8);
        racingCars.updatePositionsWithRandomNumbers(numbers);
        RacingResult racingResult = new RacingResult(racingCars.getStatus());
        List<String> winners = racingResult.selectWinners();
        List<String> expectedWinners = List.of("ruby", "react");

        //then
        Assertions.assertThat(expectedWinners).hasSameElementsAs(winners);
    }
}