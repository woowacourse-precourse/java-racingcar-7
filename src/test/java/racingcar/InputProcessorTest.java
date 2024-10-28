package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import racingcar.model.InputProcessor;

class InputProcessorTest {

    @Test
    void inputCheck() {
        // given
        InputProcessor inputProcessor = new InputProcessor("pobi,crong,honux,sean", "5");

        // then
        assertDoesNotThrow(() -> inputProcessor.validateCarNames("pobi,crong,honux,sean"));
        assertDoesNotThrow(() -> inputProcessor.validateMoveCount("5"));
    }

    @Test
    void validateCarNames_이름에_공백_포함() {
        assertThrows(IllegalArgumentException.class, () -> new InputProcessor("pobi, crong, honux, sean", "5"));
    }

    @Test
    void validateCarNames_자동차이름이_5자이상() {
        assertThrows(IllegalArgumentException.class, () -> new InputProcessor("pobiiii,crong,honux,sean", "5"));
    }


    @Test
    void validateCarNames_자동차이름이_1자미만() {
        assertThrows(IllegalArgumentException.class, () -> new InputProcessor(",c,h,s", "5"));
    }

    @Test
    void validateMoveCount_이동횟수가_1미만() {
        assertThrows(IllegalArgumentException.class, () -> new InputProcessor("pobi,crong,honux,sean", "0"));

    }

    @Test
    void validateMoveCount_이동횟수가_숫자가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> new InputProcessor("pobi,crong,honux,sean", "a"));

    }

    @Test
    void validateMoveCount_이동횟수가_음수인_경우() {
        assertThrows(IllegalArgumentException.class, () -> new InputProcessor("pobi,crong,honux,sean", "-1"));
    }
}