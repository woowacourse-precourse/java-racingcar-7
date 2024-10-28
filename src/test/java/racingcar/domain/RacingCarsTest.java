package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatusDto;

import java.util.List;

class RacingCarsTest {

    private final RacingCenter racingCenter = new RacingCenter();

    @Test
    @DisplayName("자동차 이름으로 경주에 참가할 자동차를 등록한다.")
    void registerCars() {
        //given
        List<String> carNames = List.of("kobe", "james", "tim", "curry");

        //when
        RacingCars racingCars = new RacingCars(racingCenter.registerCars(carNames));
        List<CarStatusDto> carStatusList = racingCars.getStatus();

        //then
        for (int i = 0; i < carNames.size(); i++) {
            Assertions.assertThat(carStatusList.get(i).name()).isEqualTo(carNames.get(i));
        }
    }

    @Test
    @DisplayName("부여받은 숫자에 따라, 경주 자동차가 전진하거나 정지 상태를 유지한다.")
    void updatePositionsWithRandomNumbers() {
        //given
        List<String> carNames = List.of("one", "two", "three", "four");
        RacingCars racingCars = new RacingCars(racingCenter.registerCars(carNames));

        //when
        List<Integer> numbers = List.of(1, 2, 4, 5);
        racingCars.updatePositionsWithRandomNumbers(numbers);
        List<CarStatusDto> carStatusList = racingCars.getStatus();

        List<Integer> expectedPositions = List.of(0, 0, 1, 1);
        List<Integer> currentPositions = carStatusList.stream()
                .map(CarStatusDto::position)
                .toList();

        //then
        Assertions.assertThat(expectedPositions).hasSameElementsAs(currentPositions);
    }
}