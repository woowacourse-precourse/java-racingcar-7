package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 생성값이_4이상일때_전진해야_한다(int value) {
        //given
        List<String> names = List.of("pobi");
        Cars cars = new Cars(names);

        //when
        cars.goOrStop(() -> value);

        //then
        Assertions.assertThat(cars.getCars().get(0).getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 생성값이_4미만일때_전진하면_안된다(int value) {
        //given
        List<String> names = List.of("pobi");
        Cars cars = new Cars(names);

        //when
        cars.goOrStop(() -> value);

        //then
        Assertions.assertThat(cars.getCars().get(0).getDistance()).isEqualTo(0);
    }
}
