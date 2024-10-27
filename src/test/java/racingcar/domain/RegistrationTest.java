package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegistrationTest {

    @Test
    @DisplayName("등록정보 생성 테스트")
    void create() {
        List<String> testLineup = List.of("test1", "test2", "test3");
        Long getLapCount = 1L;

        Registration testRegi = new Registration(testLineup, getLapCount);

        assertEquals(testLineup, testRegi.getLineup());
        assertEquals(getLapCount, testRegi.getLapCount());
    }
}