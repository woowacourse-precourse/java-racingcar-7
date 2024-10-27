package racingcar.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Input;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputParserTest {
    private final InputParser inputParser = InputParserFactory.create();

    @Test
    void 자동차이름들_분리후_리스트로_반환() {
        String carNames = "ph,dd,aa,ee";
        List<Car> cars = inputParser.parseRacingCarList(new Input(carNames));
        assertEquals(4, cars.size());
        assertEquals("ph", cars.getFirst().getName());
        assertEquals(0, cars.get(1).getMoveCnt());
        assertEquals("ee", cars.getLast().getName());
    }

    @Test
    void 자동차이름들_중복_존재_에러() {
        String carNames = "ph,aa,ee,aa";
        assertThatThrownBy(() -> inputParser.parseRacingCarList(new Input(carNames)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "a"})
    void 시도횟수_숫자X_에러(String input) {
        assertThatThrownBy(() -> inputParser.parseTryCount(new Input(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수_숫자_int형초과_에러() {
        String num = "2147483648"; // Integer.MAX_VALUE + 1
        assertThatThrownBy(() -> inputParser.parseTryCount(new Input(num)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}