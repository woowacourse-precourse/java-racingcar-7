package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {
    @Test
    void Cars_생성_테스트() {
        // given
        List<String> carNames = List.of("sieun", "pobi", "jun");
        List<String> expectedName = List.of("sieun", "pobi", "jun");

        // when
        Cars cars = Cars.apply(carNames);
        Cars expected = Cars.apply(expectedName);

        // then
        assertEquals(cars, expected);
    }

    @Test
    void Cars_입력_문자열이_비었을_경우() {
        // given
        List<String> emptyCarNames = List.of();

        // when & then
        assertThatThrownBy(() -> Cars.apply(emptyCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
