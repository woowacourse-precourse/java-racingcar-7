package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import static racingcar.constant.ErrorMessages.CAR_COUNT_ERROR_MESSAGE;
import static racingcar.constant.ErrorMessages.CAR_NAME_DUPLICATE_ERROR_MESSAGE;

class RacingGameServiceTest {
    @Test
    public void 자동차를_생성한다() {
        // given
        final var racingGameService = new RacingGameService();
        List<String> carNames = Arrays.asList("pobi","woni","jun");

        // when
        List<Car> registeredCars = racingGameService.createCarsWithUniqueName(carNames);

        // then
        assertThat(registeredCars.size()).isEqualTo(3);
        assertThat(registeredCars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    public void 자동차를_생성한다_중복된_이름인_경우() {
        // given
        final var racingGameService = new RacingGameService();
        List<String> carNames = Arrays.asList("pobi","woni","pobi");

        // when & then
        assertThatThrownBy(() -> racingGameService.createCarsWithUniqueName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    public void 자동차_수는_최소_2대_이상이어야_한다_2대_미만인_경우() {
        // given
        final var racingGameService = new RacingGameService();
        List<String> carNames = Arrays.asList("pobi");

        // when & then
        assertThatThrownBy(() -> racingGameService.createCarsWithUniqueName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_COUNT_ERROR_MESSAGE);
    }

    @Test
    public void 가장_많이_이동한_자동차를_우승자로_뽑는다() {
        // given
        final var racingGameService = new RacingGameService();
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        car1.move(5);
        car3.move(5);

        // when
        List<String> winners = racingGameService.selectWinners(Arrays.asList(car1, car2, car3));

        // then
        assertThat(winners).isEqualTo(Arrays.asList("pobi", "jun"));
    }
}