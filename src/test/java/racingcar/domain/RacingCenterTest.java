package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarStatusDto;
import racingcar.exception.DuplicateNameException;
import racingcar.exception.MaxRacingCarCountException;

import java.util.List;

class RacingCenterTest {

    @Test
    @DisplayName("자동차 이름으로 경주에 참가할 자동차를 등록한다.")
    void registerCars() {
        //given
        List<String> carNames = List.of("kobe", "james", "tim", "curry");

        //when
        RacingCenter racingCenter = new RacingCenter();
        List<Car> cars = racingCenter.registerCars(carNames);

        //then
        List<String> registeredCarNames = cars.stream()
                .map(Car::toCarStatusDto)
                .map(CarStatusDto::name)
                .toList();

        Assertions.assertThat(carNames).hasSameElementsAs(registeredCarNames);
    }

    @Test
    @DisplayName("중복된 자동차 이름을 입력받지 않았는지 테스트한다.")
    void validateUniqueName() {
        //given
        List<String> carNames = List.of("messi", "messi", "james");
        RacingCenter racingCenter = new RacingCenter();

        //when & then
        Assertions.assertThatThrownBy(() -> racingCenter.registerCars(carNames))
                .isInstanceOf(DuplicateNameException.class);
    }

    @Test
    @DisplayName("경주 참여 자동차가 10대 초과인 경우, 예외를 발생시킨다.")
    void validateRacingCarCountExceedsLimit() {
        //given
        List<String> carNames = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
        RacingCenter racingCenter = new RacingCenter();

        //when & then
        Assertions.assertThatThrownBy(() -> racingCenter.registerCars(carNames))
                .isInstanceOf(MaxRacingCarCountException.class);
    }

    @Test
    @DisplayName("경주 참여 자동차가 최대 10대일 때 통과하는지 테스트한다.")
    void validateRacingCarCountWithinLimit() {
        //given
        List<String> carNames = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        RacingCenter racingCenter = new RacingCenter();

        //when & then
        Assertions.assertThatCode(() -> racingCenter.registerCars(carNames))
                .doesNotThrowAnyException();
    }
}