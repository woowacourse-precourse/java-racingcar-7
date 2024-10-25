package racingcar.model.parser;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.car.Car;

class CarsParserTest {

    @Test
    @DisplayName("단일 요소 파싱 테스트")
    void parse() {
        List<Car> test = CarsParser.parse("phobi");

        assertThat(test.size()).isEqualTo(1);
        assertThat(test.getFirst().getName().getCarName()).isEqualTo("phobi");
    }

    @Test
    @DisplayName("여러 요소 파싱 테스트")
    void parse2() {
        List<Car> test = CarsParser.parse("phobi,wooni,kgy18");

        assertThat(test.size()).isEqualTo(3);
        assertThat(test.get(0).getName().getCarName()).isEqualTo("phobi");
        assertThat(test.get(1).getName().getCarName()).isEqualTo("wooni");
        assertThat(test.get(2).getName().getCarName()).isEqualTo("kgy18");
    }

    @ParameterizedTest
    @DisplayName("예외 테스트")
    @EmptySource
    @ValueSource(strings = {"wo:df", "5자를넘어감", "$%기호"})
    void invalidInputParse(String input) {
        assertThatThrownBy(() -> CarsParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}