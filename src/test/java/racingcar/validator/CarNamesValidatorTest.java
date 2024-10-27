package racingcar.validator;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingCarService;

class CarNamesValidatorTest {

    private final CarNamesValidator carNamesValidator = new CarNamesValidator();
    private final RacingCarService racingCarService = new RacingCarService();

    @Test
    @DisplayName("차 이름 문자열 오류 검증")
    public void testValidateCarNamesInput() {
        //given
        String carNames1 = "";
        String carNames2 = "car1;car2;car3";

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        carNamesValidator.validateCarNamesInput(carNames1),
                "잘못된 입력입니다");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        carNamesValidator.validateCarNamesInput(carNames2),
                "자동차 이름은 쉼표(,)를 기준으로 구분해야 합니다.");
    }

    @Test
    @DisplayName("차 이름 리스트 변환 후 길이, 중복 에러 검증")
    public void testValidateCarNamesList() {
        //given
        String carNames1 = "car1,car2car3";
        String carNames2 = "car1,car2,car2";

        List<String> listCarNames1 = racingCarService.splitCarNames(carNames1);
        List<String> listCarNames2 = racingCarService.splitCarNames(carNames2);

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        carNamesValidator.validateCarNamesList(listCarNames1),
                "이름은 5자 이하만 가능합니다.");
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        carNamesValidator.validateCarNamesList(listCarNames2),
                "자동차 이름이 중복입니다.");
    }

    @Test
    @DisplayName("차 이름 중복 검증")
    public void testIsDuplicateCarName() {
        //given
        List<String> listCarName1 = Arrays.asList("car1", "car2", "car2");
        List<String> listCarName2 = Arrays.asList("car1", "car2", "car3");
        //when
        boolean result1 = carNamesValidator.isDuplicateCarName(listCarName1);
        boolean result2 = carNamesValidator.isDuplicateCarName(listCarName2);
        //then
        Assertions.assertTrue(result1);
        Assertions.assertFalse(result2);
    }
}