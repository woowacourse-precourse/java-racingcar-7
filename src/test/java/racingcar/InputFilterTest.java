package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputFilterTest {

    @Test
    void validateCarNames() {
        // given
        InputFilter inputFilter = new InputFilter();

        // when
        inputFilter.validateCarNames("pobi,crong,honux");

        // then
        assertDoesNotThrow(() -> inputFilter.validateCarNames("pobi,crong,honux"));
    }

    @Test
    void validateMoveCount() {
        // given
        InputFilter inputFilter = new InputFilter();

        // when
        inputFilter.validateMoveCount("5");

        // then
        assertDoesNotThrow(() -> inputFilter.validateMoveCount("5"));
    }

    @Test
    void validateCarNames_자동차이름이_5자이상() {
        // given
        InputFilter inputFilter = new InputFilter();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> inputFilter.validateCarNames("pobiiii,crong,honux,sean"));
    }

    @Test
    void validateCarNames_자동차이름이_1자미만() {
        // given
        InputFilter inputFilter = new InputFilter();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> inputFilter.validateCarNames(",c,h,s"));
    }

    @Test
    void validateMoveCount_이동횟수가_1미만() {
        // given
        InputFilter inputFilter = new InputFilter();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> inputFilter.validateMoveCount("0"));
    }

    @Test
    void validateMoveCount_이동횟수가_숫자가_아닌_경우() {
        // given
        InputFilter inputFilter = new InputFilter();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> inputFilter.validateMoveCount("a"));
    }

    @Test
    void validateMoveCount_이동횟수가_음수인_경우() {
        // given
        InputFilter inputFilter = new InputFilter();

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> inputFilter.validateMoveCount("-1"));
    }

}