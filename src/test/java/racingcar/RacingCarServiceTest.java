package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarServiceTest {
    private final RacingCarService racingCarService = new RacingCarService();

    @Test
    @DisplayName("쉼표(,) 구분자로 문자열 자르기")
    void testSplitCarNames() {
        //이름이 잘못 들어온 경우

        List<String> carNames = racingCarService.splitCarNames("car1,car2,car3");
        List<String> resultCarNames = Arrays.asList("car1", "car2", "car3");

        Assertions.assertEquals(carNames, resultCarNames);
    }

    @Test
    public void testMapCarNames() throws Exception {
        //given
        List<String> carNames = new ArrayList<>(Arrays.asList("car1", "car2", "car3"));
        Map<String, String> expect = new HashMap<>();
        expect.put("car1", "");
        expect.put("car2", "");
        expect.put("car3", "");

        //when
        Map<String, String> result = racingCarService.mapCarNames(carNames);
        //then
        Assertions.assertEquals(expect, result);
    }
}