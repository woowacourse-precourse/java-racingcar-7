package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("자동차 이름을 받아서 Cars를 생성한다.")
    @Test
    void createCars() {
        //given
        List<String> carNames = List.of("pobi", "woni", "jun");
        //when
        Cars cars = Cars.fromNames(carNames);

        //then
        assertThat(cars).isEqualTo(Cars.fromNames(carNames));
    }

    @DisplayName("중복된 자동차가 있는 경우 예외를 발생한다.")
    @Test
    void duplicateCar() {
        //given
        List<String> carNames = List.of("pobi", "pobi", "jun");

        //when //then
        assertThatThrownBy(() -> Cars.fromNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 자동차가 없는 경우 예외를 발생하지 않는다.")
    @Test
    void nonDuplicateCar() {
        //given
        List<String> carNames = List.of("pobi", "woni", "jun");

        //when //then
        assertThatCode(() -> Cars.fromNames(carNames))
                .doesNotThrowAnyException();
    }
}