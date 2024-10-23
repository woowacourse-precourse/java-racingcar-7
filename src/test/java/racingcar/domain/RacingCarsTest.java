package racingcar.domain;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.exception.Exception.DUPLICATE_NAME;
import static racingcar.exception.Exception.NOT_ENOUGH_CARS;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        List<String> names = List.of("pobi", "woni");
        racingCars = RacingCars.of(names);
    }

    @Test
    void 자동차들_생성() {
        //given

        //when

        //then
        assertThat(racingCars).hasToString("pobi : \n" + "woni : ");
    }

    @Test
    void 자동차_이름_중복_예외() {
        //given

        //when
        Throwable thrown = catchThrowable(() -> RacingCars.of(List.of("pobi", "pobi")));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_NAME.getMessage());
    }

    @Test
    void 충분하지_않은_자동차_갯수_예외() {
        //given

        //when
        Throwable thrown = catchThrowable(() -> RacingCars.of(List.of("pobi")));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ENOUGH_CARS.getMessage());
    }
}
