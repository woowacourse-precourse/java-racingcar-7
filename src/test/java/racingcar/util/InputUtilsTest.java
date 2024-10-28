package racingcar.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputUtilsTest {
    private static InputStream originalSystemIn;

    @BeforeAll
    public static void setUp() {
        // 원래 System.in을 저장
        originalSystemIn = System.in;
    }

//  예외 케이스 = {"a,b,a", "A,a,B", "aaaaaa,abc,d", "\n", ",", "a,b,"}
    @Test
    void 입력_예외_테스트() {
        String input = "a,b,B";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThrows(IllegalArgumentException.class, InputUtils::readCarNameInput);
    }

//    @Test
//    void 숫자_입력_예외_테스트() {
//        String input = "-10";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        Assertions.assertThrows(IllegalArgumentException.class, InputUtils::readRaceCountInput);
//    }
}
