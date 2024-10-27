package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    private final Cars cars = new Cars();

    @Test
    void 가장_멀리간_우승자의_이름을_반환한다() {
        //given
        Car junsuCar = new RacingCar("준수", 5);
        Car tobiCar = new RacingCar("토비", 3);
        cars.add(junsuCar);
        cars.add(tobiCar);

        //when
        List<String> winners = cars.getWinners();

        //then
        assertThat(winners).containsExactly(junsuCar.getName());
    }

    @Test
    void 위치가_같을_경우_우승자는_여러명이다() {
        //given
        Car junsuCar = new RacingCar("준수", 5);
        Car tobiCar = new RacingCar("토비", 5);
        cars.add(junsuCar);
        cars.add(tobiCar);

        //when
        List<String> winners = cars.getWinners();

        //then
        assertThat(winners).containsExactly(junsuCar.getName(), tobiCar.getName());
    }

    @Test
    void 중복된_이름의_자동차는_예외가_발생한다() {
        //given
        Car junsuCar = new RacingCar("준수", 5);
        Car tobiCar = new RacingCar("준수", 5);
        cars.add(junsuCar);

        //when & then
        assertThatThrownBy(() -> cars.add(tobiCar))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름이 중복되었습니다.");
    }
}