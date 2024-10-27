package racingcar;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {
    private final Race race = new Race();

    @Test
    @DisplayName("자동차 입력 분리 테스트")
    public void testSeparateInputCars() {
        assertArrayEquals(new String[]{"test1", "test2", "test3"}, race.separateInputCars("test1,test2,test3"));
    }

}
