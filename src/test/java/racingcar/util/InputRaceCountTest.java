package racingcar.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputRaceCountTest {

    //  예외 케이스 = {"-1", "a", " ", "01"}
    @Test
    void 숫자_입력_예외_테스트() {
        String input = " ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, InputUtils::readRaceCountInput);
    }
}
