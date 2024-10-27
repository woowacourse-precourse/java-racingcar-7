package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidTest {

    @Test
    void shouldReturnNoNameWhenNoString() {
        Input input = new Input("", "1");
        Racing racing = new Racing(input.splitCarNameInput());
        assertEquals("NoName", racing.getCars()[0].getName());

        input = new Input("alpha,,beta", "1");
        racing = new Racing(input.splitCarNameInput());
        assertEquals("NoName", racing.getCars()[1].getName());
    }

    @Test
    void shouldReturnTrueWhenCarNamesIsValid() {
        assertTrue(Util.isValidCarNamesInput("alpha,beta,delta"));
        assertTrue(Util.isValidCarNamesInput("alpha,자동차"));
        assertTrue(Util.isValidCarNamesInput("alpha,,beta"));
        assertTrue(Util.isValidCarNamesInput("alpha,&*(),beta"));
    }

    @Test
    void shouldReturnFalseWhenCarNameIsNotValid() {
        assertFalse(Util.isValidCarNamesInput("alpha,beta,cccccc"));
    }

    @Test
    void shouldReturnTrueWhenCarNameHasDuplicate() {
        Input input = new Input("alpha,beta,alpha", "1");
        assertTrue(Util.hasDuplicates(input.splitCarNameInput()));
    }

    @Test
    void shouldReturnFalseWhenCarNameHasNoDuplicate() {
        Input input = new Input("alpha,beta,delta", "1");
        assertFalse(Util.hasDuplicates(input.splitCarNameInput()));
    }

    @Test
    void shouldReturnFalseWhenRoundNumberIsValid() {
        assertFalse(Util.isValidRoundNumber("a"));
        assertFalse(Util.isValidRoundNumber("ㄱ"));
        assertFalse(Util.isValidRoundNumber("^"));
        assertFalse(Util.isValidRoundNumber("-1"));
    }
}

