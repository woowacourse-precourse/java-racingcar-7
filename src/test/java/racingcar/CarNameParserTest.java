package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class CarNameParserTest {

    private CarNameParser carNameParser;

    @BeforeEach
    void setUp() {
        carNameParser = new CarNameParser();
    }

    /**
     * 1. 정상적인 입력
     * 2. 입력에 5보다 큰 문자열
     * 3. 입력에 빈 문자열
     * 4. 입력에 중복되는 자동차 이름
     * */
    @Test
    @DisplayName("splitCarNamesByComma 메서드가 입력으로 받은 문자열을 분리하는지 테스트")
    public void 자동차이름_쉼표기준_분리_테스트(){
        //given
        String inputCarNames = "car1,car2,car3";
        String[] expectedCarNames = {"car1", "car2", "car3"};
        //when
        String[] actualCarNames = carNameParser.splitCarNamesByComma(inputCarNames);
        //then
        Assertions.assertThat(expectedCarNames).isEqualTo(actualCarNames);
    }

    @Test
    @DisplayName("입력으로 최대 길이 5보다 긴 문자열이 입력되었을때 예외 발생 테스트")
    public void 자동차이름_유효성검사_길이초과_예외테스트(){
        String carName = "car12345";

        Assertions.assertThatThrownBy(()-> carNameParser.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("입력으로 빈 문자열이 입력되었을 때 예외 발생 테스트")
    public void 자동차이름_유효성검사_빈문자열_예외테스트(){
        String carName = "";

        Assertions.assertThatThrownBy(()-> carNameParser.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 빈 문자열 입니다.");
    }

    @Test
    @DisplayName("getValidatedCarNames 메서드에서 생성한 자동차 이름 리스트에 중복된 이름이 있는지 검증 테스트")
    public void 자동차이름_중복_예외테스트(){
        List<String> carNamesList = Arrays.asList("car1", "car1", "car2");

        Assertions.assertThatThrownBy(()->carNameParser.hasDuplicateCarNames(carNamesList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 이름이 있습니다.");
    }


    @Test
    @DisplayName("자동차 이름 배열을 검증 후 자동차 리스트로 반환되는지 테스트")
    public void 자동차이름_리스트_반환_테스트(){
        //given
        String[] splitCarNames = {"car1", "car2", "car3"};
        List<String> expectedCarNameList = Arrays.asList("car1", "car2", "car3");

        //when
        List<String> actualCarNameList = carNameParser.getValidatedCarNames(splitCarNames);

        //then
        Assertions.assertThat(actualCarNameList).isEqualTo(expectedCarNameList);
    }


}