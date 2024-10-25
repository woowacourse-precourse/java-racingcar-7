package racingcar;

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
    @DisplayName("차 이름을 맵의 키로 매핑하는 메서드 테스트")
    public void testMapCarNames() throws Exception {
        //given
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        Map<String, String> expect = new HashMap<>();
        expect.put("car1", "");
        expect.put("car2", "");
        expect.put("car3", "");

        //when
        Map<String, String> result = racingCarService.mapCarNames(carNames);
        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    @DisplayName("이동 시 -를 값으로 추가한 후 다시 map으로 반환하는 메서드")
    public void testMoveCar() throws Exception {
        //given
        List<String> winCarNames = Arrays.asList("car1", "car3");
        Map<String, String> expect = new HashMap<>();
        expect.put("car1", "-");
        expect.put("car2", "");
        expect.put("car3", "-");

        Map<String, String> result = new HashMap<>();
        result.put("car1", "");
        result.put("car2", "");
        result.put("car3", "");

        //when
        result = racingCarService.moveCar(result, winCarNames);
        //then

        Assertions.assertEquals(expect, result);
    }
}