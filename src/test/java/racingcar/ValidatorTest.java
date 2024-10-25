package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

//    @Test
//    void 문자_검증(){
//        String input = "32a,b,c,d";
//        Validator validator = new Validator();
//        assertThrows(IllegalArgumentException.class,() ->{validator.validateCharacter(input);
//        });
//    }
//    @Test
//    void 이름길이_검증(){
//        String input = "java,object";
//        String[] split = input.split(",");
//        Validator validator = new Validator();
//        assertThrows(IllegalArgumentException.class, () -> {
//            validator.validateNameLength(split);
//        });
//    }
//
//    @Test
//    void 정상이름길이(){
//        String input = "John,Mary,Paul";
//        Validator validator = new Validator();
//        String[] split = input.split(",");
//        assertDoesNotThrow(() -> validator.validateNameLength(split));
//
//    }
//
//    @Test
//    void 널_빈문자_검사(){
//        String input = "John, Mary, ,john";
//        Validator validator = new Validator();
//        String[] split = input.split(",");
//        assertThrows(IllegalArgumentException.class, () -> {
//            validator.validateEmpty(split);
//        });
//
//    }

    @Test
    void 다른특수문자_검증(){
        String input = "pobi,woni,jun;";
        Validator validator = new Validator();
        assertThrows(IllegalArgumentException.class,()->{
            validator.validate(input);
        });
    }

    @Test
    void 이름길이_검증(){
        String input = "pobi,leewoni,jun;";
        Validator validator = new Validator();
        assertThrows(IllegalArgumentException.class,()->{
            validator.validate(input);
        });
    }

    @Test
    void 빈문자_검증(){
        String input = "pobi, ,woni,jun;";
        Validator validator = new Validator();
        assertThrows(IllegalArgumentException.class,()->{
            validator.validate(input);
        });
    }
    @Test
    void 정상_검증(){
        String input = "pobi,woni,jun";
        Validator validator = new Validator();
        assertDoesNotThrow(()->{validator.validate(input);});
    }


}