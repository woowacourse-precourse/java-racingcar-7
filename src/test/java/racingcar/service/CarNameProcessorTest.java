package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarNameProcessorTest {

    CarNameProcessor carNameProcessor = new CarNameProcessor();

    @Test
    void 입력_유효성_테스트(){

        assertTrue(carNameProcessor.isValid("asd,qwe,zxcd"));
        assertTrue(carNameProcessor.isValid("asd"));

        assertFalse( carNameProcessor.isValid(",asdf"));                    // 입력 앞에 쉼표가 있는 경우
        assertFalse( carNameProcessor.isValid("asdf,"));                    // 입력 마지막에 쉼표가 있는경우
        assertFalse( carNameProcessor.isValid("asdz%asdf"));                // 구분자가 다른 특수문자인 경우
        assertFalse( carNameProcessor.isValid("asdf,qwe2w,zxca"));          // 이름이 대문자 소문자 알파벳이 아닌경우
        assertFalse( carNameProcessor.isValid("asdf,asd,zxca,asd"));        // 자동차가 중복입력된 경우
        assertFalse( carNameProcessor.isValid(null));                       // null이 입력된 경우

    }

    @Test
    void 입력_문자열_자르기(){
        assertEquals(List.of("qwe","asd","zxc"), carNameProcessor.parseCarNames("qwe,asd,zxc"));
        assertEquals(List.of("qwe"), carNameProcessor.parseCarNames("qwe"));
    }

    @Test
    void 에외_발생_테스트(){
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
           carNameProcessor.parseCarNames(null);
        });
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            carNameProcessor.parseCarNames("asd,asd");
        });
    }
}
