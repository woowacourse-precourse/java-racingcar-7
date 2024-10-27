package racingcar.global;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void convertInputToCarNames() {
        List<String> inputs = new ArrayList<>();
        inputs.add("pob i,wo-ni,j u n");
        inputs.add("pob i, wo-ni, j u n");
        inputs.add("pob i , wo-ni , j u n");

        List<String> expect = new ArrayList<>();
        expect.add("pob i");
        expect.add("wo-ni");
        expect.add("j u n");

        for(String input : inputs) {
            assertEquals(InputValidator.convertInputToCarNames(input), expect);
        }
    }
}