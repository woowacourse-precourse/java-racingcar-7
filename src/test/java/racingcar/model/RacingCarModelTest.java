package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarModelTest {

    private final RacingCarModel racingCarModel = new RacingCarModel();

    @Test
    @DisplayName("입력받은 자동차 이름 문자열을 ','기준으로 나누어 리스트로 반환한다")
    void splitCarNamesTest(){
        //given
        String carNameString = "pobi,woni,jun";

        //when
        racingCarModel.splitCarNameString(carNameString);
        List<String> carNameList = racingCarModel.getCarNameList();

        //then
        assertThat(carNameList).isEqualTo(Arrays.asList(carNameString.split(",")));
    }

    @Test
    @DisplayName("자동차가 전진했을 시 그에 따라 value값을 1씩 증가시킨다")
    void updateCarMapTest(){
        //given
        String carName = "pobi";
        int forwardCount = 1;

        //when
        racingCarModel.createCarMap(carName, forwardCount);
        racingCarModel.updateCarMap(carName);

        //then
        int updatedForwardCount = racingCarModel.getForwardCount(carName);
        assertThat(updatedForwardCount).isEqualTo(2);
    }




}
