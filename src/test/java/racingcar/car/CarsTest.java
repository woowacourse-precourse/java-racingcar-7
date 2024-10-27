package racingcar.car;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

    @Test
    void 이동거리가_가장_많은_우승자를_반환한다() {
        //given
        List<String> names = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(names);

        //when
        cars.goOrStop(() -> 5);
        final List<Car> winners = cars.findWinners();

        //then
        Assertions.assertThat(winners).hasSize(names.size());
    }

    @ParameterizedTest
    @MethodSource("provideDuplicatedNames")
    void 중복되는_자동차_이름이_있으면_예외가_발생한다(List<String> duplicatedNames) {
        //when & then
        Assertions.assertThatThrownBy(() -> {
                    Cars cars = new Cars(duplicatedNames);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재하면 안됩니다.");
    }

    private static Stream<Arguments> provideDuplicatedNames() {
        return Stream.of(
                Arguments.of(List.of("pobi", "pobi", "jun")),
                Arguments.of(List.of("pobi", " pobi", "jun")),
                Arguments.of(List.of("pobi", "pobi ", "jun")),
                Arguments.of(List.of("pobi", "Pobi ", "jun"))
        );
    }
}
