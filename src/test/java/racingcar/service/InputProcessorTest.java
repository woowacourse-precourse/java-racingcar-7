package racingcar.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputProcessorTest {

    InputProcessor inputProcessor = new InputProcessor();

    @Test
    void 입력_유효성_테스트(){

        assertTrue(inputProcessor.isValid("asd,qwe,zxcd"));
        assertTrue(inputProcessor.isValid("asd"));

        assertFalse( inputProcessor.isValid(",asdf"));                    // 입력 앞에 쉼표가 있는 경우
        assertFalse( inputProcessor.isValid("asdf,"));                    // 입력 마지막에 쉼표가 있는경우
        assertFalse( inputProcessor.isValid("asdz%asdf"));                // 구분자가 다른 특수문자인 경우
        assertFalse( inputProcessor.isValid("asdf,qwe2w,zxca"));          // 이름이 대문자 소문자 알파벳이 아닌경우
        assertFalse( inputProcessor.isValid("asdf,asd,zxca,asd"));        // 자동차가 중복입력된 경우
        assertFalse( inputProcessor.isValid(null));                       // null이 입력된 경우

    }

    @Test
    void 입력_문자열_자르기(){
        assertEquals(List.of("qwe","asd","zxc"), inputProcessor.parseCarNames("qwe,asd,zxc"));
        assertEquals(List.of("qwe"), inputProcessor.parseCarNames("qwe"));
    }

    @Test
    void 에외_발생_테스트(){
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            inputProcessor.parseCarNames(null);
        });
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            inputProcessor.parseCarNames("asd,asd");
        });
    }

    @Test
    void 반복횟수_유효성_테스트(){

        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            inputProcessor.isValidRound(null);
        });
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            inputProcessor.isValidRound("A123");
        });
    }
}
