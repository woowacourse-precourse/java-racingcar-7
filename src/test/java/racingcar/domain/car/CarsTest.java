package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCarNamesDTO;

class CarsTest {

    @Test
    void 생성자가_제대로_작동하는지_확인하는_테스트() {
        //given
        RacingCarNamesDTO racingCarNamesDTO = new RacingCarNamesDTO("Car1,Car2,Car3");

        //When
        Cars cars = new Cars(racingCarNamesDTO);

        //then
        assertThat(racingCarNamesDTO.getCarNames().size()).isEqualTo(cars.size());
        assertThat(cars.getCarByNumber(0).getCarName()).isEqualTo("Car1");
        assertThat(cars.getCarByNumber(1).getCarName()).isEqualTo("Car2");
        assertThat(cars.getCarByNumber(2).getCarName()).isEqualTo("Car3");
    }

    @Test
    void 유효하지_않은_인덱스에_대해_예외_발생() {
        //given
        RacingCarNamesDTO racingCarNamesDTO = new RacingCarNamesDTO("Car1,Car2");

        //when
        Cars cars = new Cars(racingCarNamesDTO);

        //then
        assertThatThrownBy(() -> cars.getCarByNumber(3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}