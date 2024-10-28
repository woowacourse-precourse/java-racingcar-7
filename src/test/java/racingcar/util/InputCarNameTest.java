package racingcar.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputCarNameTest {

//  예외 케이스 = {"a,b,a", "A,a,B", "aaaaaa,abc,d", "\n", ",", "a,b,"}
    @Test
    void 입력_예외_테스트() {
        String input = "a,b,B";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, InputUtils::readCarNameInput);
    }
}
