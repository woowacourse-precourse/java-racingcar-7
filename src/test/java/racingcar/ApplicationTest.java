package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
    @Test
    void validateCarNames() {
        String[] carNames = {"pobi", "woni", "jun", "javaji"};
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> Application.validateCarNames(carNames));
        assertEquals(ExceptionCode.NAME_LENGTH_EXCEEDED.getMessage(), exception.getMessage());
    }

    @Test
    void printRoundResults() {
        LinkedHashMap<String, Integer> cars = new LinkedHashMap<>();
        cars.put("pobi", 3);
        cars.put("woni", 5);
        cars.put("jun", 2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Application.printRoundResults(cars);

        String expectedOutput = "pobi : - - - \n" + "woni : - - - - - \n" + "jun : - - \n";
        String actualOutput = outputStream.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);

        System.setOut(originalOut);

    }

}
