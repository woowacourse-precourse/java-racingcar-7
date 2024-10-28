package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {
    @Test
    @DisplayName("랜덤 숫자 생성")
    public void testRandomNumber() {
        int count = 7;
        List<Integer> result = RandomNumber.createRandomNumber(count);

        assertEquals(count, result.size(), "리스트의 크기는 요청한 count와 같아야 합니다.");

        // 각 숫자가 0과 9 사이인지 확인
        result.forEach(number -> {
            assertTrue(number >= 0 && number <= 9, "모든 숫자는 0 이상 9 이하이어야 합니다.");
        });
    }

}
