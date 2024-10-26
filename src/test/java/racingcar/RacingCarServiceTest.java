package racingcar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarServiceTest extends RacingCarService {
    private final RacingCarService racingCarService = new RacingCarService();

    @Override
    @DisplayName("난수 제어를 위한 오버라이딩")
    public boolean canMove() {
        return true;
    }

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

    @Test
    @DisplayName("이동할 차 목록 반환하는 메서드")
    public void testListMoveCarNames() throws Exception {
        RacingCarServiceTest racingCarServiceTest = new RacingCarServiceTest();

        //given
        List<String> expect = Arrays.asList("car1", "car3");

        //when
        List<String> result = racingCarServiceTest.listMoveCarNames(expect);

        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    @DisplayName("넘어온 결과 map으로 부터 최대 value를 찾는 메서드")
    public void testFindMaxMove() throws Exception {
        //given
        String expect = "----";
        Map<String, String> racingResult = new HashMap<>();
        racingResult.put("car1", "---");
        racingResult.put("car2", "--");
        racingResult.put("car3", "----");
        racingResult.put("car4", "----");

        //when
        String result = racingCarService.findMaxMove(racingResult);

        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    @DisplayName("결과와 최대 이동거리를 받아 우승자 리스트를 반환하는 메서드")
    public void testListRacingWinners() throws Exception {
        //given
        List<String> expect = Arrays.asList("car3", "car4");
        Map<String, String> racingResult = new HashMap<>();
        racingResult.put("car1", "---");
        racingResult.put("car2", "--");
        racingResult.put("car3", "----");
        racingResult.put("car4", "----");
        String maxMove = racingCarService.findMaxMove(racingResult);

        //when
        List<String> result = racingCarService.listRacingWinners(racingResult, maxMove);
        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    @DisplayName("입력을 검증하는 메서드")
    public void testValidateCarNamesInput() throws Exception {
        //given
        //공백이 들어올 경우
        String carNames1 = "";
        //5자 이상이 들어올 경우
        String carNames2 = "car1,car2car3";
        //구분자로 쉼표가 없을 경우
        String carNames3 = "car1;car2;car3";
        //차 이름 중복입력했을 경우
        String carNames4 = "car1,car2,car2";

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        racingCarService.validateCarNamesInput(carNames1),
                "잘못된 입력입니다");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        racingCarService.validateCarNamesInput(carNames2),
                "자동차 이름은 쉼표(,)를 기준으로 구분해야 합니다.");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        racingCarService.validateCarNamesInput(carNames3),
                "이름은 5자 이하만 가능합니다.");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        racingCarService.validateCarNamesInput(carNames4),
                "자동차 이름이 중복입니다.");
    }

    @Test
    @DisplayName("차 이름 중복 확인 메서드")
    public void testIsDuplicatieCarName() throws Exception {
        //given
        List<String> listCarName1 = Arrays.asList("car1", "car2", "car2");
        List<String> listCarName2 = Arrays.asList("car1", "car2", "car3");
        //when
        boolean result1 = racingCarService.isDuplicateCarName(listCarName1);
        boolean result2 = racingCarService.isDuplicateCarName(listCarName2);
        //then
        Assertions.assertTrue(result1);
        Assertions.assertFalse(result2);
    }
}