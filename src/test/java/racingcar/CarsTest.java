package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

public class CarsTest {

    @Test
    @DisplayName("Cars 객체를 생성할 수 있다")
    void Cars_객체를_생성할_수_있다() {
        //given
        List<Car> carList = Arrays.asList(
                new Car("pobi", ""),
                new Car("woni", "")
        );

        //when
        Cars cars = new Cars(carList);

        //then
        assertThat(cars.getCars().getFirst().getName()).isEqualTo("pobi");

    }

    @Test
    @DisplayName("중복된 자동차 이름이 있으면 예외가 발생한다")
    void 중복된_자동차_이름이_있으면_예외가_발생한다() {
        //given
        //when
        List<Car> duplicateCars = Arrays.asList(
                new Car("pobi", ""),
                new Car("pobi", "")
        );

        //then
        assertThatThrownBy(() -> new Cars(duplicateCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차의 최대 이동 거리를 구할 수 있다.")
    void 가장_멀리_이동한_자동차의_최대_이동_거리를_구할_수_있다() {
        //given
        List<Car> carList = Arrays.asList(
                new Car("pobi", "---"),
                new Car("woni", "----")
        );

        Cars cars = new Cars(carList);

        //when
        int maximum = cars.findMaxPosition(carList);

        //then
        assertEquals(4, maximum);
    }

    @Test
    @DisplayName("최대 이동거리에 도달한 자동차를 찾아 리스트에 담을 수 있다.")
    void 최대_이동거리에_도달한_자동차를_찾을_수_있다() {
        //given
        List<Car> carList = Arrays.asList(
                new Car("pobi", "---"),
                new Car("woni", "----"),
                new Car("jun", "----")
        );

        Cars cars = new Cars(carList);

        //when
        List<Car> carsWinners = cars.findWinners();

        //then
        assertEquals("woni", carsWinners.getFirst().getName());
        assertEquals("jun", carsWinners.get(1).getName());
    }
}
