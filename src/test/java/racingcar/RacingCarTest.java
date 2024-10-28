package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    public void setup() {
        racingCar = new RacingCar();
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    public void 글자수가_5보다_클_때_예외테스트() {
        String input = "pobi,woni,jackson\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingCar.run();
        });
    }

    @Test
    public void 시도할_횟수가_숫자가_아닐_때_예외테스트() {
        String input = "pobi,woni,jun\naaa\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingCar.run();
        });
    }

    @Test
    public void 차_이름이_중복됐을_때_예외테스트() {
        String input = "pobi,pobi\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingCar.run();
        });
    }

    @Test
    public void 차_이름이_공백일_때_예외테스트() {
        String input = ",pobi\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            racingCar.run();
        });
    }

}
