package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
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

    @Test
    void 값이_4이상이면_전진한다() {
        List<String> input = List.of("pobi");
        Cars cars = Cars.valueOf(input);

        ValueGenerator moveGenerator = () -> 4;
        cars.move(moveGenerator);

        assertThat(cars.getExecutionResult()).isEqualTo(List.of("pobi : -"));
    }

    @Test
    void 값이_4미만이면_이동하지_않는다() {
        List<String> input = List.of("pobi");
        Cars cars = Cars.valueOf(input);

        ValueGenerator stayGenerator = () -> 3;
        cars.move(stayGenerator);

        assertThat(cars.getExecutionResult()).isEqualTo(List.of("pobi : "));
    }
}