package racingcar;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCarsNamesTest {

    @Test
    @DisplayName("입력 테스트")
    void testInput() {
        // 가상의 콘솔 입력값 설정
        String input = "pobi,woni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<String> expected = List.of("pobi", "woni", "jun");
        List<String> result = Application.getCarsName();
        assertEquals(expected, result);
    }


}