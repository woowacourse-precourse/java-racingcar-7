package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.valuegenerator.ValueGenerator;

class CarsTest {
    @Test
    void 실행_결과를_반환한다() {
        List<String> input = List.of("pobi", "woni", "jun");

        Cars cars = Cars.valueOf(input);

        cars.getExecutionResult();

        assertThat(cars.getExecutionResult()).isEqualTo(List.of("pobi : ", "woni : ", "jun : "));
    }

    @Test
    void 최종_결과를_반환한다() {
        List<String> input = List.of("pobi", "woni", "jun");

        Cars cars = Cars.valueOf(input);

        cars.getExecutionResult();

        assertThat(cars.getTotalResult()).isEqualTo(List.of("pobi", "woni", "jun"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 값이_4이상이면_전진한다(int movableValue) {
        List<String> input = List.of("pobi");
        Cars cars = Cars.valueOf(input);

        ValueGenerator moveGenerator = () -> movableValue;
        cars.moveEachRandomly(moveGenerator);

        assertThat(cars.getExecutionResult()).isEqualTo(List.of("pobi : -"));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 값이_4미만이면_이동하지_않는다(int unmovableValue) {
        List<String> input = List.of("pobi");
        Cars cars = Cars.valueOf(input);

        ValueGenerator stayGenerator = () -> unmovableValue;
        cars.moveEachRandomly(stayGenerator);

        assertThat(cars.getExecutionResult()).isEqualTo(List.of("pobi : "));
    }
}