package racingcar.model.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        assertEquals(test.size(), 1);
        assertEquals(test.getFirst().getName().getCarName(), "phobi");
    }

    @Test
    @DisplayName("여러 요소 파싱 테스트")
    void parse2() {
        List<Car> test = CarsParser.parse("phobi,wooni,kgy18");

        assertEquals(test.size(), 3);
        assertEquals(test.get(0).getName().getCarName(), "phobi");
        assertEquals(test.get(1).getName().getCarName(), "wooni");
        assertEquals(test.get(2).getName().getCarName(), "kgy18");
    }

    @ParameterizedTest
    @DisplayName("예외 테스트")
    @EmptySource
    @ValueSource(strings = {"wo:df", "5자를넘어감", "$%기호"})
    void invalidInputParse(String input) {
        assertThrows(IllegalArgumentException.class, () -> CarsParser.parse(input));
    }
}