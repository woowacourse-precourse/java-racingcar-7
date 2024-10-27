package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    @Test
    void shouldThrowExceptionWhenCarNamesNotValid() {
        Input input = new Input("alpha,beta,ccccccc", "1");
        assertThrows(IllegalArgumentException.class, () -> {
            Util.throwExceptionInputIsNotValid(input.getCarNames(), input.getRounds(), input.splitCarNameInput());
        });
    }

    @Test
    void shouldThrowExceptionWhenRoundNumberNotValid() {
        Input input = new Input("alpha,beta", "a");
        assertThrows(IllegalArgumentException.class, () -> {
            Util.throwExceptionInputIsNotValid(input.getCarNames(), input.getRounds(), input.splitCarNameInput());
        });
    }

    @Test
    void shouldThrowExceptionWhenRoundNumberIsNegative() {
        Input input = new Input("alpha,beta", "-1");
        assertThrows(IllegalArgumentException.class, () -> {
            Util.throwExceptionInputIsNotValid(input.getCarNames(), input.getRounds(), input.splitCarNameInput());
        });
    }

    @Test
    void shouldThrowExceptionWhenRoundNumberIsZero() {
        Input input = new Input("alpha,beta", "0");
        assertThrows(IllegalArgumentException.class, () -> {
            Util.throwExceptionInputIsNotValid(input.getCarNames(), input.getRounds(), input.splitCarNameInput());
        });
    }

    @Test
    void shouldThrowExceptionWhenCarNamesHaveDuplicate() {
        Input input = new Input("alpha,beta,alpha", "1");
        assertThrows(IllegalArgumentException.class, () -> {
            Util.throwExceptionInputIsNotValid(input.getCarNames(), input.getRounds(), input.splitCarNameInput());
        });
    }
}

