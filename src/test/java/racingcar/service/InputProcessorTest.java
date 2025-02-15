package racingcar.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InputProcessorTest {

    InputProcessor inputProcessor = new InputProcessor();

    @Test
    void 올바른_자동차명_입력_유효성_테스트(){

        assertTrue(inputProcessor.isValid("asd,qwe,zxcd"));
        assertTrue(inputProcessor.isValid("asd"));
    }

    @Test
    void 잘못된_자동차명_입력_유효성_테스트(){

        assertFalse( inputProcessor.isValid(",asdf"));                    // 입력 앞에 쉼표가 있는 경우
        assertFalse( inputProcessor.isValid("asdf,"));                    // 입력 마지막에 쉼표가 있는경우
        assertFalse( inputProcessor.isValid("asdz%asdf"));                // 구분자가 다른 특수문자인 경우
        assertFalse( inputProcessor.isValid("asdf,qwe2w,zxca"));          // 이름이 대문자 소문자 알파벳이 아닌경우
        assertFalse( inputProcessor.isValid("asdf,asd,zxca,asd"));        // 자동차가 중복입력된 경우
        assertFalse( inputProcessor.isValid(null));                       // null이 입력된 경우
    }

    @Test
    void 입력_문자열_분리_테스트(){
        assertEquals(List.of("qwe","asd","zxc"), inputProcessor.parseCarNames("qwe,asd,zxc"));
        assertEquals(List.of("qwe"), inputProcessor.parseCarNames("qwe"));
    }

    @Test
    void 중복_자동차명입력_에외_발생_테스트(){
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            inputProcessor.parseCarNames("asd,asd");
        });
    }

    @Test
    void 잘못된_반복횟수입력_예외발생_테스트(){
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            inputProcessor.isValidRound("A123");
        });
    }
}
