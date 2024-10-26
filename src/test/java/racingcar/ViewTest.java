package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class ViewTest {


    @DisplayName("이름 분할 테스트")
    @ParameterizedTest
    @MethodSource("expectedAndResult")
    void inputCarNames(String input, List<String> expected) {


        View view = new View();

        List<String> result = view.inputCarNames(input);

        // 결과 검증
        assertEquals(expected, result);
    }

    static Stream<Arguments> expectedAndResult() {
        return Stream.of(
            arguments("woni,pobi", Arrays.asList("woni", "pobi")),
            arguments("car1", Arrays.asList("car1")),
            arguments("pobi ,woni ", Arrays.asList("pobi","woni"))
        );
    }

    @DisplayName("Car 객체 리스트 생성 테스트")
    @Test
    void addCars() {
        View view = new View();
        List<String> carNames = Arrays.asList("pobi", "woni", "crong");

        List<Car> result = view.addCars(carNames);

        assertEquals("pobi", result.get(0).getName());
        assertEquals("woni", result.get(1).getName());
        assertEquals("crong", result.get(2).getName());
    }

}
