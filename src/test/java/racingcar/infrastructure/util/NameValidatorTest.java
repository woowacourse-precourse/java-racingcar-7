package racingcar.infrastructure.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameValidatorTest {
    private NameValidator nameValidator;

    @BeforeEach
    public void before(){
        nameValidator = new NameValidator();
    }

    //=======================Exception Test=======================//
    @Test
    void 글자의_길이가_5초과인지_확인하기() {
        List<String> names = List.of("test", "name", "jijongkwon");

        // 5이상인지 확인
        assertThrows(IllegalArgumentException.class, () -> nameValidator.validRacingCarName(names));
    }
}