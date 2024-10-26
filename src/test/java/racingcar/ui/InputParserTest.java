package racingcar.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputParserTest {
    private final InputParser inputParser = new InputParser();
    @Test
    void 이름_추출_성공() {
        //given
        String names = "audi,benz,bmw,kia";

        //when
        String[] carNames = inputParser.parseNames(names);

        //then
        assertThat(carNames.length).isEqualTo(4);
        assertThat(carNames).containsExactly("audi", "benz", "bmw", "kia");
    }

    @Test
    void 시도횟수_추출_성공() {
        //given
        String tryCount = "3";

        //when
        int tc = inputParser.parseTryCount(tryCount);

        //then
        assertThat(tc).isEqualTo(3);
    }

    @Test
    void 추출_실패_이름5자이상() {
        //given
        String names = "audi,benz,porsche,bmw,kia";

        //then
        assertThrows(IllegalArgumentException.class, () -> inputParser.parseNames(names));
    }

    @Test
    void 추출_실패_이름공백() {
        //given
        String names1 = "audi,benz,,porsche,bmw,kia";
        String names2 = "audi,benz, ,porsche,bmw,kia";

        //then
        assertThrows(IllegalArgumentException.class, () -> inputParser.parseNames(names1));
        assertThrows(IllegalArgumentException.class, () -> inputParser.parseNames(names2));
    }

    @Test
    void 추출_실패_시도횟수0() {
        //given
        String tryCount = "0";

        //then
        assertThrows(IllegalArgumentException.class, () -> inputParser.parseTryCount(tryCount));
    }

    @Test
    void 추출_실패_시도횟수음수() {
        //given
        String tryCount = "-3";

        //then
        assertThrows(IllegalArgumentException.class, () -> inputParser.parseTryCount(tryCount));
    }

    @Test
    void 추출_실패_시도횟수정수아님() {
        //given
        String tryCount = "times";

        //then
        assertThrows(IllegalArgumentException.class, () -> inputParser.parseTryCount(tryCount));
    }

}