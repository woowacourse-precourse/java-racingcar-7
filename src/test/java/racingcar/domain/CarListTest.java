package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class CarListTest {

    @Test
    void 유효한_자동차_리스트_생성_테스트() {
        // given
        String input = "pobi,woni,jun";
        // when
        CarList carList = new CarList(input);
        List<Car> cars = carList.getCarList();
        // then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void 공백_이름이_포함될_경우_예외발생() {
        // given
        String input = "pobi,,jun";
        // when
        assertThatThrownBy(() -> new CarList(input))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.EMPTY_NAME_ERROR);
    }

    @Test
    void 이름이_5자를_초과할_때_예외() {
        // given
        String input = "pobi,longname";
        // when
        assertThatThrownBy(() -> new CarList(input))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Validator.INVALID_NAME_LENGTH_ERROR);
    }
}
