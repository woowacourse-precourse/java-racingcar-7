package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void 문자_검증(){
        String input = "32a,b,c,d";
        Validator validator = new Validator();
        assertThrows(IllegalArgumentException.class,() ->{validator.validateCharacter(input);
        });
    }
    @Test
    void 이름길이_검증(){
        String input = "java,object";
        Validator validator = new Validator();
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNameLength(input);
        });
    }

    @Test
    void 정상이름길이(){
        String input = "John,Mary,Paul";
        Validator validator = new Validator();

        assertDoesNotThrow(() -> validator.validateNameLength(input));

    }

    @Test
    void 널_빈문자_검사(){
        String input = "John, Mary, ,john";
        Validator validator = new Validator();
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateEmpty(input);
        });

    }


}